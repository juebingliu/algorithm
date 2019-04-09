package com.netty.ws.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import java.util.Date;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;

/**
 * @author juebing
 * @date 2018/11/26 15:38
 * @description
 */
public class WebSocketHandler  extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        if(msg instanceof FullHttpRequest) {
            handleHttpRequest(channelHandlerContext,(FullHttpRequest) msg);
        }else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(channelHandlerContext,(WebSocketFrame) msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     * 第一次握手为http协议
     * @param ctx
     * @param req
     * @throws Exception
     */
    private void handleHttpRequest(ChannelHandlerContext ctx,FullHttpRequest req) throws Exception {
        if (!req.getDecoderResult().isSuccess()
                || (!"websocket".equals(req.headers().get("Upgrade")))) {
            sendHttpResponse(ctx,req,new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }

        //握手
        WebSocketServerHandshakerFactory  wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:8080/websocket",null,false);
        handshaker = wsFactory.newHandshaker(req);
        if (handshaker == null) {
            //不支持
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else {
            //握手时将ws相关的编解码器添加到pipeline中
            handshaker.handshake(ctx.channel(),req);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx,WebSocketFrame frame) {
        if (frame instanceof CloseWebSocketFrame) {
            //关闭指令
            handshaker.close(ctx.channel(),((CloseWebSocketFrame) frame).retain());
            return;
        }
        if (frame instanceof PingWebSocketFrame) {
            //ping消息
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
        }
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass().getName()));
        }

        String request = ((TextWebSocketFrame) frame).text();
        System.out.println(String.format("%s received %s",ctx.channel(),request));
        ctx.channel().write(new TextWebSocketFrame(request + ",欢迎使用Netty WebSocket 服务,现在时刻:" +new Date().toString()));
    }

    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse resp){
        if(resp.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(resp.getStatus().toString(), CharsetUtil.UTF_8);
            resp.content().writeBytes(buf);
            buf.release();
            setContentLength(resp, resp.content().readableBytes());
        }

        ChannelFuture f = ctx.channel().writeAndFlush(resp);
        if (!isKeepAlive(req) || resp.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}