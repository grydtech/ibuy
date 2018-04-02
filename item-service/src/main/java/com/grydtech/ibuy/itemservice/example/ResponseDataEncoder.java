package com.grydtech.ibuy.itemservice.example;

import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class ResponseDataEncoder
        extends MessageToByteEncoder<GenericResponse> {

    @Override
    protected void encode(ChannelHandlerContext ctx,
                          GenericResponse msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getStatus());
    }
}