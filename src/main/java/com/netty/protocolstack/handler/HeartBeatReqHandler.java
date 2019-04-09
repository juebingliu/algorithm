package com.netty.protocolstack.handler;

import com.netty.protocolstack.MessageType;
import com.netty.protocolstack.pojo.Header;
import com.netty.protocolstack.pojo.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author juebing
 * @date 2018/11/27 18:05
 * @description
 */
public class HeartBeatReqHandler extends ChannelInboundHandlerAdapter {

    private volatile ScheduledFuture<?> heartBeat;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 如果握手成功，主动发送心跳消息
        NettyMessage message = (NettyMessage) msg;
        Header header = message.getHeader();
        if (header != null)
        {
            if (header.getType() == MessageType.LOGIN_RESP)
            {
                if (heartBeat == null)
                {
                    heartBeat = ctx.executor().scheduleAtFixedRate(new HeartBeatTask(ctx),
                            0,
                            5000,
                            TimeUnit.MILLISECONDS);
                }
            }
            else if (header.getType() == MessageType.HEARTBEAT_RESP)
            {
                System.out.println("Client receive server heart beat message :" + message);
            }
            else
            {
                ctx.fireChannelRead(msg);
            }
        }
        else
        {
            ctx.fireExceptionCaught(new Throwable("没有Header"));
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        try
        {
            ctx.fireExceptionCaught(cause);
        }
        finally
        {
            closeHeartBeat();
        }

    }


    private void closeHeartBeat()
    {
        if (heartBeat != null)
        {
            heartBeat.cancel(true);
            heartBeat = null;
        }
    }


    /**
     * 心跳任务
     */
    private class HeartBeatTask implements Runnable
    {
        final ChannelHandlerContext ctx;

        public HeartBeatTask(final ChannelHandlerContext ctx)
        {
            this.ctx = ctx;
        }

        @Override
        public void run()
        {
            ctx.writeAndFlush(buildHeartBeat());
            System.out.println("Client send heart beat message to server : ----> " + heartBeat);
        }

    }

    private NettyMessage buildHeartBeat()
    {
        NettyMessage heartBeat = new NettyMessage();
        Header header = new Header();
        header.setType(MessageType.HEARTBEAT_REQ);
        heartBeat.setHeader(header);
        heartBeat.setBody(null);
        return heartBeat;
    }

}