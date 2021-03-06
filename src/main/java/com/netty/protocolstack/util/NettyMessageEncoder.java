package com.netty.protocolstack.util;

import com.netty.marshalling.MarshallingCodeCFactory;
import com.netty.protocolstack.pojo.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;
import java.util.Map;

/**
 * @author juebing
 * @date 2018/11/27 17:12
 * @description
 */
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {

    NettyMarshallingEncoder nettyMarshallingEncoder;

    public NettyMessageEncoder() {
        nettyMarshallingEncoder = MarshallingCodeCFactory.buildMarshallingEncoder();
    }


    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {

        if (msg == null || msg.getHeader() == null)
        {
            throw new Exception("The encode message is null");
        }
        ByteBuf sendBuf = Unpooled.buffer();
        sendBuf.writeInt(msg.getHeader().getCrcCode());
        sendBuf.writeInt(msg.getHeader().getLength());
        sendBuf.writeLong(msg.getHeader().getSessionID());
        sendBuf.writeByte(msg.getHeader().getType());
        sendBuf.writeByte(msg.getHeader().getPriority());
        sendBuf.writeInt(msg.getHeader().getAttachment().size());
        for (Map.Entry<String, Object> entry : msg.getHeader().getAttachment().entrySet())
        {
            String key = entry.getKey();
            byte[] keyArray = key.getBytes("UTF-8");
            sendBuf.writeInt(keyArray.length);
            sendBuf.writeBytes(keyArray);
            Object value = entry.getValue();
            nettyMarshallingEncoder.encode(ctx, value, sendBuf);
        }

        if (msg.getBody() != null)
        {
            nettyMarshallingEncoder.encode(ctx, msg.getBody(), sendBuf);
        }
        sendBuf.setInt(4, sendBuf.readableBytes());
        out.add(sendBuf);
    }
}