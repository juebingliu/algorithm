package com.netty.xml.dom4j.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author juebing
 * @date 2018/11/23 11:54
 * @description
 */
@XmlType(propOrder = {"versionNo", "orderNo", "receveTime"})
public class OrderResponseHead {

    private String versionNo;
    private String orderNo;
    private String receveTime;

    public OrderResponseHead() {
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

    @XmlElement(name = "receveTime")
    public String getReceveTime() {
        return receveTime;
    }

    public void setReceveTime(String receveTime) {
        this.receveTime = receveTime;
    }

    @Override
    public String toString() {
        return "OrderResponseHead{" +
                "versionNo='" + versionNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", receveTime='" + receveTime + '\'' +
                '}';
    }
}