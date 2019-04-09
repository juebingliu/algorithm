package com.netty.xml.dom4j.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author juebing
 * @date 2018/11/23 11:42
 * @description
 */
@XmlType(propOrder = {"versionNo", "orderNo", "orderDate"})
public class OrderRequestHead {

    private String versionNo;
    private String orderNo;
    private String orderDate;

    public OrderRequestHead() {
    }

    @XmlElement(name = "versionNo")
    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    @XmlElement(name = "orderNo")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @XmlElement(name = "orderDate")
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "OrderRequestHead{" +
                "versionNo='" + versionNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}