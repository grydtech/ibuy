package com.grydtech.ibuy.itemservice;

import com.grydtech.ibuy.itemservice.requests.GetItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by Gavindya on 3/30/2018.
 */
//public class EndPointHandler implements ChannelInboundHandlerAdapter<> {
public class EndPointHandler extends/* SimpleChannelInboundHandler<String>{

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("message - "+s);
    }
}
*/  ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {

        GetItemRequest msg = new GetItemRequest();
        msg.setItem("Item is 123");
        ChannelFuture future = ctx.writeAndFlush(msg.toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println(msg.toString());
        ctx.close();
    }
}
