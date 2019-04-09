package com.netty.protobuf.server;

import com.netty.protobuf.proto.SubscribeReqProto;
import com.netty.protobuf.proto.SubscribeRespProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author juebing
 * @date 2018/11/20 19:24
 * @description
 */
public class SubReqServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
        if("ljb".equalsIgnoreCase(req.getUserName())) {
            System.out.println("Service accept clientandserver subscribe req : [" + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getSubReqID()));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private SubscribeRespProto.SubscribeResp resp(int subReqId) {
        return SubscribeRespProto.SubscribeResp.newBuilder()
                .setSubReqID(subReqId)
                .setRespCode(9999)
                .setDesc("received").build();
    }
}