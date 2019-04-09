package com.netty.udp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ThreadLocalRandom;

/**
 * @author juebing
 * @date 2018/11/26 16:56
 * @description
 */
public class ChineseProverbServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final String[] dict = {"aaaa","bbbb","cccc","dddd","eeee","ffff"};

    private String nextQuote() {
        int quoteId = ThreadLocalRandom.current().nextInt(dict.length);
        return dict[quoteId];
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        String req = packet.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        if("dict query".equals(req)) {
            ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("result: " + nextQuote(), CharsetUtil.UTF_8),packet.sender()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}