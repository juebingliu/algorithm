package com.netty.demo.server.timeserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author juebing
 * @date 2018/11/19 14:37
 * @description
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    private int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];//获取字节数，并建立字节数组
//        buf.readBytes(req);//将缓冲区的字节读出来
//        //String body = new String(req,"UTF-8");
//        //拆包改造
//        String body = new String (req,"UTF-8").substring(0,req.length-System.getProperty("line.separator").length());
        //System.out.println("The time server receive order :" + body);
        String body = (String) msg;
        System.out.println("The time server receive order :" + body + "; the counter is :" + ++counter);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        //拆包改造
        currentTime = currentTime + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());//组织响应
        ctx.writeAndFlush(resp);//异步回写并发送
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}