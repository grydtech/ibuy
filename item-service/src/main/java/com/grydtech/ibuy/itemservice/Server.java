package com.grydtech.ibuy.itemservice;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class Server {

    public static void main(String[] args) {
        new Server(8000).run();
    }
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    public void run(){
        EventLoopGroup bossgroup = new NioEventLoopGroup();
        EventLoopGroup workergroup = new NioEventLoopGroup();

        try{
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(bossgroup, workergroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer());

            bootstrap.bind(port).sync().channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossgroup.shutdownGracefully();
            workergroup.shutdownGracefully();

        }
    }

}

