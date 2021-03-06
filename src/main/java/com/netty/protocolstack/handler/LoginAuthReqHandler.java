package com.netty.protocolstack.handler;

import com.netty.protocolstack.MessageType;
import com.netty.protocolstack.pojo.Header;
import com.netty.protocolstack.pojo.NettyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author juebing
 * @date 2018/11/27 17:48
 * @description
 */
public class LoginAuthReqHandler extends ChannelInboundHandlerAdapter {

    /**
     * 握手
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyMessage message = buildLoginReq();
        ctx.writeAndFlush(message);
        System.out.println("客户端发送的握手请求："+message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;

        // 如果是握手应答消息，需要判断是否握手成功
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_RESP)
        {
            if (message.getBody() != null)
            {
                String loginResult = message.getBody().toString();
                if (loginResult.equals("login_ok"))
                {
                    System.out.println("Login is success :" + message);
                    // 透传给后面的Handler处理
                    ctx.fireChannelRead(msg);
                }
                else
                {
                    // 握手失败，关闭连接
                    ctx.close();
                    System.out.println("握手失败，关闭连接");
                }
            }
            else
            {
                // 握手失败，关闭连接
                ctx.close();
                System.out.println("握手失败，关闭连接");
            }
        }
        else
        {
            // 如果不是握手应答消息，直接透传
            ctx.fireChannelRead(msg);
        }


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }

    private NettyMessage buildLoginReq()
    {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType(MessageType.LOGIN_REQ);
        message.setHeader(header);
        return message;
    }

}