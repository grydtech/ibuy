package com.grydtech.ibuy.itemservice.example;

import com.grydtech.ibuy.itemservice.requests.AddItemRequest;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class RequestDataEncoder
        extends MessageToByteEncoder<AddItemRequest> {

    private final Charset charset = Charset.forName("UTF-8");

    @Override
    protected void encode(ChannelHandlerContext ctx,
                          AddItemRequest msg, ByteBuf out) throws Exception {

        out.writeInt(msg.getItemQty());
        out.writeInt(msg.getItemId().length());
        out.writeCharSequence(msg.getItemId(), charset);
    }
}