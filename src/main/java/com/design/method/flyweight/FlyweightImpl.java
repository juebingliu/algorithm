package com.design.method.flyweight;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class FlyweightImpl implements Flyweight {
    @Override
    public void action(int arg) {
        System.out.println("参数值: " + arg);
    }
}
