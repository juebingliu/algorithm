package com.netty.protocolstack.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

/**
 * @author juebing
 * @date 2018/11/27 17:04
 * @description
 */
public class NettyMarshallingEncoder extends MarshallingEncoder {
    public NettyMarshallingEncoder(MarshallerProvider provider) {
        super(provider);
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        try {
            super.encode(ctx, msg, out);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}