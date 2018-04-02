package com.grydtech.ibuy.itemservice.example;

import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Gavindya on 3/30/2018.
 */

public class SimpleProcessingHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf tmp;

    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("Handler added");
        tmp = ctx.alloc().buffer(4);
    }

    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("Handler removed");
        tmp.release();
        tmp = null;
    }


    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg;
        tmp.writeBytes(m);
        m.release();
        if (tmp.readableBytes() >= 4) {
            // request processing
            AddItemRequest requestData = new AddItemRequest();
            requestData.setItemId(String.valueOf(tmp.readInt()));
            GenericResponse responseData = new GenericResponse();
            responseData.setMessage(String.valueOf(Integer.valueOf(requestData.getItemId()) * 2));
            ChannelFuture future = ctx.writeAndFlush(responseData);
            future.addListener(ChannelFutureListener.CLOSE);
            }
        }
}