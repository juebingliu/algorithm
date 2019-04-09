package com.design.method.proxy.dynamicProxy;

import java.util.Random;

/**
 * Created by juebingliu on 2018/6/8.
 */
//真实主题
public class Car implements Moveable{
    @Override
    public void move() throws Exception {
        Thread.sleep(new Random().nextInt(1000));
        System.out.println("汽车行驶中…");
    }
}
