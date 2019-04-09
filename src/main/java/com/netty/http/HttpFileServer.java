package com.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author juebing
 * @date 2018/11/21 10:11
 * @description
 */
public class HttpFileServer {

    private static final String DEFAULT_URL = "/src/main/java/com";

    public static void main(String[] args) throws Exception{
        int port = 8080;
        if(args!= null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e) {
            }
        }
        String url = DEFAULT_URL;
        if(args.length > 1) {
            url = args[1];
        }
        new HttpFileServer().run(port,url);
    }

    public void run(final int port, final String url) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //请求解码器
                            socketChannel.pipeline().addLast("http-decoder",new HttpRequestDecoder());
                            //将多个消息转换为单一的FullHttpRequest或者FullHttpResponse
                            socketChannel.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65536));
                            //响应编码器
                            socketChannel.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                            //加大异步发送的码流，适合文件传输
                            socketChannel.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                            //自定义handler
                            socketChannel.pipeline().addLast(new HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture f = b.bind("10.106.64.73",port).sync();
            System.out.println("HTTP 文件目录服务器启动，网址是 ：http://10.106.64.73:"+ port + url);
            f.channel().closeFuture().sync();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}