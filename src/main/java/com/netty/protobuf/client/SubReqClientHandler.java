package com.netty.protobuf.client;

import com.netty.protobuf.proto.SubscribeReqProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author juebing
 * @date 2018/11/20 19:39
 * @description
 */
public class SubReqClientHandler extends ChannelInboundHandlerAdapter {

    public SubReqClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0;i<10;i++) {
            ctx.write(req(i));
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive Server response : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private SubscribeReqProto.SubscribeReq req(int i) {
        return SubscribeReqProto.SubscribeReq.newBuilder()
                .setSubReqID(i)
                .setUserName("ljb")
                .setProductName("product")
                .setPhoneNumber("12345")
                .setAddress("a city").build();
    }
}