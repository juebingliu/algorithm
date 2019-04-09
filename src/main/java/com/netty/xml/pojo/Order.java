package com.netty.xml.pojo;

/**
 * @author juebing
 * @date 2018/11/22 11:48
 * @description
 */
public class Order {
    private long orderNumber;
    private Address billTo;
    private Shipping shipping;
    private Address shipTo;
    private Float total;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Address getBillTo() {
        return billTo;
    }

    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Address getShipTo() {
        return shipTo;
    }

    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", billTo=" + billTo +
                ", shipping=" + shipping +
                ", shipTo=" + shipTo +
                ", total=" + total +
                '}';
    }
}