package com.netty.demo.client.timeclient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author juebing
 * @date 2018/11/19 17:17
 * @description
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    //private final ByteBuf firstMsg;

    private int counter;

    private byte[] req;
    public TimeClientHandler() {
//        byte[] req = "QUERY TIME ORDER".getBytes();
//        firstMsg = Unpooled.buffer(req.length);
//        firstMsg.writeBytes(req);
        req = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //写并发送
        //ctx.writeAndFlush(firstMsg);
        //粘包、拆包模拟
        ByteBuf message = null;
        for(int i = 0 ; i<100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req,"UTF-8");
//        System.out.println("Now is :" +body + "; the counter is :" + ++counter);
        String body = (String) msg;
        System.out.println("Now is :" +body + "; the counter is :" + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}