package com.netty.udp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * @author juebing
 * @date 2018/11/26 17:37
 * @description
 */
public class ChineseProverbClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
        String resp = datagramPacket.content().toString(CharsetUtil.UTF_8);
        if(resp.startsWith("result: ")) {
            System.out.println(resp);
            channelHandlerContext.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}