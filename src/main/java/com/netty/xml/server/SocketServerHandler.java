package com.netty.xml.server;

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

import java.io.File;
import java.util.Date;

/**
 * @author juebing
 * @date 2018/11/23 11:37
 * @description
 */
public class SocketServerHandler extends ChannelInboundHandlerAdapter {

    public SocketServerHandler() {
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg);
        String resultStr = (String) msg;
        OrderRequest req = XmlUtil.unmarshal(resultStr, OrderRequest.class);
        File f = new File("D://orderReq.xml");
//        JaxbUtil.convertToXml(req,f);
//        System.out.println("接收报文：");
//        System.out.println(JaxbUtil.convertToJavaBean(OrderRequest.class,f));

        //开始响应客户端
        OrderResponse resp = new OrderResponse();
        OrderResponseHead head = new OrderResponseHead();
        head.setVersionNo(req.getHead().getVersionNo());
        head.setOrderNo(req.getHead().getOrderNo());
        head.setReceveTime(DateUtil.date2Str(new Date(),"yyyyMMddHHmmss"));
        OrderResponseBody body = new OrderResponseBody();
        body.setStatus("01");
        body.setRespCode("E0000");
        body.setRespDesc("SUCCESS");
        body.setCompleteTime(DateUtil.date2Str(new Date(),"yyyyMMddHHmmss"));
        resp.setHead(head);
        resp.setBody(body);
        String respStr = XmlUtil.marshal(resp,"UTF-8");
        ByteBuf respBuf = Unpooled.copiedBuffer(respStr.getBytes());
        ctx.writeAndFlush(respBuf);
    }

//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}