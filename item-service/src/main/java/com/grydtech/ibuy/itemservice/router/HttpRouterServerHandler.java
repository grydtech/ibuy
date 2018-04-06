package com.grydtech.ibuy.itemservice.router;

/**
 * Created by Gavindya on 4/1/2018.
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grydtech.ibuy.itemservice.handlers.AddItemHandler;
import com.grydtech.ibuy.itemservice.handlers.GetItemHandler;
import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import com.grydtech.ibuy.itemservice.requests.GetItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.*;
import io.netty.handler.codec.http.router.RouteResult;
import io.netty.handler.codec.http.router.Router;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.util.List;

@ChannelHandler.Sharable
public class HttpRouterServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final Router<Class> router;

    public HttpRouterServerHandler(Router<Class> router) {
        this.router = router;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (HttpUtil.is100ContinueExpected(req)) {
            ctx.writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE));
            return;
        }

        HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), req);

        List<InterfaceHttpData> dataSet = decoder.getBodyHttpDatas();
//        InterfaceHttpData data = decoder.getBodyHttpData("id");
        for(InterfaceHttpData interfaceHttpData : dataSet){
            System.out.println(interfaceHttpData.toString());
            if (interfaceHttpData.getHttpDataType() == InterfaceHttpData.HttpDataType.Attribute) {
                Attribute attribute = (Attribute) interfaceHttpData;
                String value;
                try {
                    value = attribute.getValue();
                    System.out.println(attribute.getName()+ ":" + value);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



//        HttpPostStandardRequestDecoder httpPostStandardRequestDecoder = new HttpPostStandardRequestDecoder(req);
//        httpPostStandardRequestDecoder.getBodyHttpData("id").touch().toString();
//        ByteBuf jsonBuf = req.content();
//        String jsonStr = jsonBuf.toString(CharsetUtil.UTF_8);
////        System.out.println(jsonStr);
//
        HttpResponse res = createResponse(req, router);
        flushResponse(ctx, req, res);
    }



    private static HttpResponse createResponse(HttpRequest req, Router<Class> router) {

        RouteResult<Class> routeResult = router.route(req.getMethod(), req.getUri());

        GenericResponse response =new GenericResponse();
        Class handler = routeResult.target().getClass();

        if(handler.getSimpleName().equalsIgnoreCase("AddItemHandler")){
            try {
                AddItemHandler addItemHandler = (AddItemHandler) handler.newInstance();
                response = addItemHandler.handle(createAddItemRequest(routeResult));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }else if(handler.getSimpleName().equalsIgnoreCase("GetItemHandler")){
            try {
                GetItemHandler getItemHandler = (GetItemHandler) handler.newInstance();
                response = getItemHandler.handle(createGetItemRequest(routeResult));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }else{
            response.setMessage("unhandlable");
            response.setStatus(504);
        }

        return createFullHttpResponseJSON(response);
//        return createFullHttpResponse(response,req, router,routeResult);

    }

    private static FullHttpResponse createFullHttpResponseJSON(GenericResponse genericResponse){
        ObjectMapper mapper = new ObjectMapper();
        String content = "";
        try {
            content = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(genericResponse);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        FullHttpResponse res = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.copiedBuffer(content, CharsetUtil.UTF_8)
        );

        res.headers().set(HttpHeaders.Names.CONTENT_TYPE, "json");
        res.headers().set(HttpHeaders.Names.CONTENT_LENGTH, res.content().readableBytes());

        return res;
    }


    private static FullHttpResponse createFullHttpResponse(GenericResponse genericResponse,
                                                           HttpRequest req,
                                                           Router<Class> router,
                                                           RouteResult<Class> routeResult){

        StringBuilder content = new StringBuilder();

        content.append("router: \n" + router + "\n");

        content.append("req: " + req + "\n\n");

        content.append("routeResult: \n");
        content.append("target: " + routeResult.target() + "\n");
        content.append("pathParams: " + routeResult.pathParams() + "\n");
        content.append("queryParams: " + routeResult.queryParams() + "\n\n");

        content.append("response:  " + genericResponse.toString() + "\n");

        content.append("allowedMethods: " + router.allowedMethods(req.getUri()));

        FullHttpResponse res = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.copiedBuffer(content.toString(), CharsetUtil.UTF_8)
        );

        res.headers().set(HttpHeaders.Names.CONTENT_TYPE, "text/plain");
        res.headers().set(HttpHeaders.Names.CONTENT_LENGTH, res.content().readableBytes());

        return res;

    }

    private static AddItemRequest createAddItemRequest(RouteResult<Class> routeResult ){
        AddItemRequest addItemRequest = new AddItemRequest();
        addItemRequest.setItemId(routeResult.queryParam("itemId"));
        addItemRequest.setQty(Integer.valueOf(routeResult.queryParam("qty")));
        addItemRequest.setLen(routeResult.queryParam("len"));
        return addItemRequest;
    }

    private static GetItemRequest createGetItemRequest(RouteResult<Class> routeResult ){
        GetItemRequest getItemRequest = new GetItemRequest();
        getItemRequest.setItem(routeResult.queryParam("item"));
        return getItemRequest;
    }


    private static ChannelFuture flushResponse(ChannelHandlerContext ctx, HttpRequest req, HttpResponse res) {
        if (!HttpHeaders.isKeepAlive(req)) {
            return ctx.writeAndFlush(res).addListener(ChannelFutureListener.CLOSE);
        } else {
            res.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            return ctx.writeAndFlush(res);
        }
    }
}
