package com.test;

import com.design.method.proxy.cglib.CGLibProxy;
import com.design.method.proxy.cglib.Train;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class CGLibProxyTest {
    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        Train t = (Train) proxy.getProxy(Train.class);
        t.move();
    }
}
