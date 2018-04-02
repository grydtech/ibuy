package com.grydtech.ibuy.itemservice.router;

/**
 * Created by Gavindya on 4/1/2018.
 */
import com.grydtech.ibuy.itemservice.handlers.Handler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.router.RouteResult;
import io.netty.handler.codec.http.router.Router;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class HttpRouterServerHandler extends SimpleChannelInboundHandler<HttpRequest> {
    private final Router<Handler> router;

    public HttpRouterServerHandler(Router<Handler> router) {
        this.router = router;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, HttpRequest req) {
        if (HttpHeaders.is100ContinueExpected(req)) {
            ctx.writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE));
            return;
        }

        HttpResponse res = createResponse(req, router);
        flushResponse(ctx, req, res);
    }



    private static HttpResponse createResponse(HttpRequest req, Router<Handler> router) {

        RouteResult<Handler> routeResult = router.route(req.getMethod(), req.getUri());
//        System.out.println(routeResult.target().handle();

        // Display debug info.
        //
        // For simplicity of this example, route targets are just simple strings.
        // But you can make them classes, and here once you get a target class,
        // you can create an instance of it and dispatch the request to the instance etc.
        StringBuilder content = new StringBuilder();

        content.append("router: \n" + router + "\n");

        content.append("req: " + req + "\n\n");

        content.append("routeResult: \n");
        content.append("target: " + routeResult.target() + "\n");
        content.append("pathParams: " + routeResult.pathParams() + "\n");
        content.append("queryParams: " + routeResult.queryParams() + "\n\n");

        content.append("allowedMethods: " + router.allowedMethods(req.getUri()));

        FullHttpResponse res = new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.copiedBuffer(content.toString(), CharsetUtil.UTF_8)
        );

        res.headers().set(HttpHeaders.Names.CONTENT_TYPE,   "text/plain");
        res.headers().set(HttpHeaders.Names.CONTENT_LENGTH, res.content().readableBytes());

        return res;
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
