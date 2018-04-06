package com.grydtech.ibuy.itemservice.router;

/**
 * Created by Gavindya on 4/1/2018.
 */
import com.grydtech.ibuy.itemservice.handlers.AddItemHandler;
import com.grydtech.ibuy.itemservice.handlers.GetItemHandler;
import com.grydtech.ibuy.itemservice.handlers.NotFoundHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.router.Router;

public class HttpRouterServer {
    public static final int PORT = 8000;

    public static void main(String[] args) throws Exception {
        // This is an example router, it will be used at HttpRouterServerHandler.
        //
        // For simplicity of this example, route targets are just simple strings.
        // But you can make them classes, and at HttpRouterServerHandler once you
        // get a target class, you can create an instance of it and dispatch the
        // request to the instance etc.
        Router<Class> router = new Router<Class>()
//        Router router = new Router<>()
                .POST("/addItem", AddItemHandler.class)
                .GET("/getItem/:id" , GetItemHandler.class)
                /*.GET("/articles/:id", "Article show page") */
                .notFound(NotFoundHandler.class);
        System.out.println(router);

        NioEventLoopGroup bossGroup   = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .childOption(ChannelOption.TCP_NODELAY, java.lang.Boolean.TRUE)
                    .childOption(ChannelOption.SO_KEEPALIVE, java.lang.Boolean.TRUE)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpRouterServerInitializer(router));

            Channel ch = b.bind(PORT).sync().channel();
            System.out.println("Server started: http://127.0.0.1:" + PORT + '/');

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}