package com.grydtech.ibuy.itemservice.example;

import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import com.grydtech.ibuy.itemservice.requests.GetItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {

//        AddItemRequest msg = new AddItemRequest();
//        msg.setItemId("123");
//        msg.setQty(500);
//        msg.setLen(
//                "all work and no play makes jack a dull boy");
//        ChannelFuture future = ctx.writeAndFlush(msg);

        GetItemRequest msg = new GetItemRequest();
        msg.setItem("123");
        ChannelFuture future = ctx.writeAndFlush(msg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println((GenericResponse)msg);
        ctx.close();
    }
}
