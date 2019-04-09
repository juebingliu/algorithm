package com.netty.xml.dom4j.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author juebing
 * @date 2018/11/23 11:50
 * @description
 */
@XmlRootElement(name = "order")
@XmlType(propOrder = {"head", "body"})
public class OrderRequest {

    private OrderRequestHead head;
    private OrderRequestBody body;

    public OrderRequest() {
    }

    @XmlElement(name = "head")
    public OrderRequestHead getHead() {
        return head;
    }

    public void setHead(OrderRequestHead head) {
        this.head = head;
    }

    @XmlElement(name = "body")
    public OrderRequestBody getBody() {
        return body;
    }

    public void setBody(OrderRequestBody body) {
        this.body = body;
    }

}