package com.netty.xml.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author juebing
 * @date 2018/11/23 10:58
 * @description
 */
public class SocketServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        if(args!= null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new SocketServer().bind(port);
    }

    public void bind(int port) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            socketChannel.pipeline().addLast(new StringDecoder());
//                            socketChannel.pipeline().addLast(new ByteArrayEncoder());
                            //自定义handler
                            //socketChannel.pipeline().addLast(new CumulatorHandler(CharsetUtil.UTF_8));
                            socketChannel.pipeline().addLast(new SocketServerHandler());
                        }
                    });
            //绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            //关闭监听
            f.channel().closeFuture().sync();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}