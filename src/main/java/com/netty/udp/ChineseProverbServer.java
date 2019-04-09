package com.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @author juebing
 * @date 2018/11/26 16:50
 * @description
 */
public class ChineseProverbServer {
    public static void main(String[] args) throws Exception{
        int port = 8080;
        if(args!= null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new ChineseProverbServer().run(port);
    }
    public void run(int port) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //udp协议
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)
                    .handler(new ChineseProverbServerHandler());
            b.bind(port).sync().channel().closeFuture().await();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }
}