package com.grydtech.ibuy.itemservice.example;

import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class RequestDecoder extends ReplayingDecoder<AddItemRequest> {

    private final Charset charset = Charset.forName("UTF-8");

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in, List<Object> out) throws Exception {

        AddItemRequest data = new AddItemRequest();
        data.setItemId(String.valueOf(in.readInt()));
        int strLen = in.readInt();
        data.setLen(
                in.readCharSequence(strLen, charset).toString());
        out.add(data);
    }
}