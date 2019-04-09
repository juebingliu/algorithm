package com.netty.demo.server.timeserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author juebing
 * @date 2018/11/19 14:28
 * @description
 */
public class TimeServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        if(args!= null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new TimeServer().bind(port);
    }

    public void bind(int port) throws Exception {
        //配置服务端的NIO线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());

            //绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();
            //关闭监听
            f.channel().closeFuture().sync();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //优雅关闭链接
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}