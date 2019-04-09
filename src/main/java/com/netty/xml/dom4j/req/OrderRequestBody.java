package com.netty.xml.dom4j.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author juebing
 * @date 2018/11/23 11:46
 * @description
 */
@XmlType(propOrder = {"productName", "productNum", "amount", "address"})
public class OrderRequestBody {

    private String productName;
    private String productNum;
    private String amount;
    private String address;

    public OrderRequestBody() {
    }

    @XmlElement(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @XmlElement(name = "productNum")
    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    @XmlElement(name = "amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @XmlElement(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderRequestBody{" +
                "productName='" + productName + '\'' +
                ", productNum='" + productNum + '\'' +
                ", amount='" + amount + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}