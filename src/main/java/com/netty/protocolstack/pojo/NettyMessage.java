package com.netty.protocolstack.pojo;

/**
 * @author juebing
 * @date 2018/11/27 15:14
 * @description
 */
public class NettyMessage {
    private Header header;
    private Object body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "NettyMessage{" +
                "header=" + header +
                '}';
    }
}