package com.grydtech.ibuy.itemservice.router;

/**
 * Created by Gavindya on 4/1/2018.
 */
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.BadClientSilencer;
import io.netty.handler.codec.http.router.Router;


public class HttpRouterServerInitializer extends ChannelInitializer<SocketChannel> {
    private final HttpRouterServerHandler handler;
    private final BadClientSilencer       badClientSilencer = new BadClientSilencer();

    public HttpRouterServerInitializer(Router router) {
        handler = new HttpRouterServerHandler(router);
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline()
                .addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(1048576))
                .addLast(handler)
                .addLast(badClientSilencer);
    }
}