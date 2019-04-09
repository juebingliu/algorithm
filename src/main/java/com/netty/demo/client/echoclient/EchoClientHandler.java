package com.netty.demo.client.echoclient;

import com.netty.xml.dom4j.req.OrderRequest;
import com.netty.xml.dom4j.req.OrderRequestBody;
import com.netty.xml.dom4j.req.OrderRequestHead;
import com.util.DateUtil;
import com.util.GenerateUniqueId;
import com.util.XmlUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author juebing
 * @date 2018/11/20 14:39
 * @description
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private int counter;

    static final String ECHO_REQ = "Hi,Welcome to Netty.$_";

    public EchoClientHandler() {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for(int i =0 ;i<5 ;i++){
            OrderRequest request = new OrderRequest();
            OrderRequestHead head = new OrderRequestHead();
            head.setVersionNo("1.0");
            head.setOrderNo(GenerateUniqueId.getUniqueIdSingleShort36());
            head.setOrderDate(DateUtil.date2Str(new Date(),"yyyyMMddHHmmss"));
            OrderRequestBody body = new OrderRequestBody();
            body.setProductName("abcdef");
            body.setProductNum("10");
            body.setAmount("100.00");
            body.setAddress("a city");
            request.setHead(head);
            request.setBody(body);
            String reqStr = XmlUtil.marshal(request,"UTF-8");
            System.out.println("请求报文："+reqStr);
            reqStr+="$_";
            ctx.writeAndFlush(Unpooled.copiedBuffer(reqStr.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("响应报文："+body);
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
}