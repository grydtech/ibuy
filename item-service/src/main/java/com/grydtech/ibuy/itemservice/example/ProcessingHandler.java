package com.grydtech.ibuy.itemservice.example;

import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class ProcessingHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        System.out.println(msg.getClass());

//        AddItemRequest requestData = (AddItemRequest) msg;
//        GenericResponse responseData = new GenericResponse();
//        responseData.setStatus(Integer.valueOf(requestData.getItemId()) * 2);
//        ChannelFuture future = ctx.writeAndFlush(responseData);
//        future.addListener(ChannelFutureListener.CLOSE);
//        System.out.println(requestData);
    }
}