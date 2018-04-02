package com.grydtech.ibuy.itemservice.example;

import com.grydtech.ibuy.itemservice.responses.GenericResponse;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class ResponseDataDecoder
        extends ReplayingDecoder<GenericResponse> {

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in, List<Object> out) throws Exception {

        GenericResponse data = new GenericResponse();
        data.setStatus(in.readInt());
        out.add(data);
    }
}