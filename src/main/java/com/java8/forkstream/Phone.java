package com.java8.forkstream;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/24 19:14
 * @description
 */
public class Phone {

    private String name;
    private int price;
    private String cpu;
    private SystemType systemType;

    public Phone(String name, int price, String cpu, SystemType systemType) {
        this.name = name;
        this.price = price;
        this.cpu = cpu;
        this.systemType = systemType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public SystemType getSystemType() {
        return systemType;
    }

    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
    }
}