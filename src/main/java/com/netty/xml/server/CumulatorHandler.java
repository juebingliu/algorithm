package com.netty.xml.server;

/**
 * @author juebing
 * @date 2018/11/23 11:19
 * @description
 */

import io.netty.buffer.ByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * 计算报文包的长度
 */
public class CumulatorHandler extends ByteToMessageDecoder {

    private int curLength;
    private Charset charset;

    public CumulatorHandler(Charset charset) {
        this.charset = charset;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //服务端接收到的长度
        curLength += byteBuf.readableBytes();
        //判断是否为空buffer
        if(byteBuf instanceof EmptyByteBuf){
            reset();
            return;
        }
        System.out.println("接收报文总长度...:"+curLength);
        reset();
    }

    private void reset() {
        curLength = 0;
    }
}