package com.netty.demo.server.echoserver;

import com.netty.xml.dom4j.req.OrderRequest;
import com.netty.xml.dom4j.resp.OrderResponse;
import com.netty.xml.dom4j.resp.OrderResponseBody;
import com.netty.xml.dom4j.resp.OrderResponseHead;
import com.util.DateUtil;
import com.util.XmlUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author juebing
 * @date 2018/11/20 11:44
 * @description
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    int counter = 0;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        String body = (String) msg;
//        System.out.println("This is " + ++counter +" times receive clientandserver : [" +body +"]");
//        body += "$_";
//        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//        ctx.writeAndFlush(echo);
        String body = (String) msg;
        System.out.println("请求报文："+body);
        OrderRequest req = XmlUtil.unmarshal(body,OrderRequest.class);
        OrderResponse resp = new OrderResponse();

        OrderResponseHead head = new OrderResponseHead();
        head.setVersionNo(req.getHead().getVersionNo());
        head.setOrderNo(req.getHead().getOrderNo());
        head.setReceveTime(req.getHead().getOrderDate());
        OrderResponseBody body1 = new OrderResponseBody();
        body1.setStatus("01");
        body1.setRespCode("0000");
        body1.setRespDesc("success");
        body1.setCompleteTime(DateUtil.date2Str(new Date(),"yyyyMMddHHmmss"));
        resp.setHead(head);
        resp.setBody(body1);

        String respStr = XmlUtil.marshal(resp,"UTF-8");
        System.out.println("响应报文："+respStr);

        respStr+="$_";
        ByteBuf echo = Unpooled.copiedBuffer(respStr.getBytes());
        ctx.writeAndFlush(echo);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}