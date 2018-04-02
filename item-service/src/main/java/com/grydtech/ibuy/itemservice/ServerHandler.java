package com.grydtech.ibuy.itemservice;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.internal.ObjectCleaner;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class ServerHandler  extends SimpleChannelInboundHandler<String> {

//    private static final ChannelGroup channels = new DefaultChannelGroup();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
//        Channel in = channelHandlerContext.channel();
//        for(Channel c : channels){
//
//        }
        System.out.println("message read - " + s);
    }
}