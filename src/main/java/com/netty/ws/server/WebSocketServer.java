package com.netty.ws.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author juebing
 * @date 2018/11/26 15:23
 * @description
 */
public class WebSocketServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        if(args!= null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new WebSocketServer().run(port);
    }

    public void run(int port)  throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup WorkerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,WorkerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("http-codec",new HttpServerCodec());
                            socketChannel.pipeline().addLast("aggregator",new HttpObjectAggregator(65536));
                            socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                            //自定义handler
                            socketChannel.pipeline().addLast(new WebSocketHandler());
                        }
                    });
            Channel ch = b.bind(port).sync().channel();

            System.out.println("Web socket server started at port " + port + '.');
            System.out.println("Open your browser and navigate to http://localhost:" + port +"/");

            ch.closeFuture().sync();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            WorkerGroup.shutdownGracefully();
        }
    }
}