package com.netty.xml.client;

import com.netty.xml.dom4j.req.OrderRequest;
import com.netty.xml.dom4j.req.OrderRequestBody;
import com.netty.xml.dom4j.req.OrderRequestHead;
import com.util.DateUtil;
import com.util.GenerateUniqueId;
import com.util.XmlUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author juebing
 * @date 2018/11/23 15:11
 * @description
 */
public class SocketClientHandler extends ChannelInboundHandlerAdapter {

    private OrderRequest req;
    private OrderRequestHead head;
    private OrderRequestBody body;

    public SocketClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        OrderRequest req = new OrderRequest();
        OrderRequestHead head = new OrderRequestHead();
        head.setVersionNo("1.0");
        head.setOrderNo(GenerateUniqueId.getUniqueIdSingleShort36());
        head.setOrderDate(DateUtil.date2Str(new Date(),"yyyyMMddHHmmss"));
        OrderRequestBody body = new OrderRequestBody();
        body.setProductName("abcde");
        body.setProductNum("10");
        body.setAmount("100.00");
        body.setAddress("a city");
        req.setHead(head);
        req.setBody(body);
        String reqXml = XmlUtil.marshal(req,"UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer(reqXml.getBytes());
        ctx.writeAndFlush(buf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //String body = (String) msg;
        //String respXml = XmlUtil.unmarshal(body, OrderResponse.class);
//        JaxbUtil.convertToXml(req,new File("D://order.xml"));
        System.out.println("响应报文："+ msg);
        //System.out.println(JaxbUtil.convertToJavaBean(OrderResponse.class,new File("D://order.xml")));

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