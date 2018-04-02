package com.grydtech.ibuy.itemservice;

import com.grydtech.ibuy.itemservice.example.ClientHandler;
import com.grydtech.ibuy.itemservice.example.RequestDataEncoder;
import com.grydtech.ibuy.itemservice.example.ResponseDataDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Gavindya on 3/30/2018.
 */
public class EndPoint {

    public static void main(String[] args) {
        new EndPoint("localhost",8000).run();
    }

    private final String host;
    private final int port;

    public EndPoint(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run(){
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioServerSocketChannel.class)
                    /*.option(ChannelOption.SO_KEEPALIVE, true)*/
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new StringEncoder(),
                                    new StringDecoder(),
                                    new EndPointHandler());
                        }

//                        @Override
//                        public void initChannel(SocketChannel ch) throws Exception {
//                            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()),
//                                    new StringEncoder(),
//                                    new StringDecoder(),
//                                    new EndPointHandler());
//                        }
                    });

            ChannelFuture channel = bootstrap.connect(host,port).sync();
            channel.channel().closeFuture().sync();
//            BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

            while (true){
                try{
//                    channel.write(in.readLine()+"\n");
                }
                catch (/*IO*/Exception e){
                    e.printStackTrace();
                }
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            group.shutdownGracefully();
        }
    }

}
