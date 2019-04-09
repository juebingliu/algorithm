package com.netty.xml.dom4j.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author juebing
 * @date 2018/11/23 11:53
 * @description
 */
@XmlRootElement(name = "order")
@XmlType(propOrder = {"head", "body"})
public class OrderResponse {
    private OrderResponseHead head;
    private OrderResponseBody body;

    public OrderResponse() {
    }

    @XmlElement(name = "head")
    public OrderResponseHead getHead() {
        return head;
    }

    public void setHead(OrderResponseHead head) {
        this.head = head;
    }

    @XmlElement(name = "body")
    public OrderResponseBody getBody() {
        return body;
    }

    public void setBody(OrderResponseBody body) {
        this.body = body;
    }
}