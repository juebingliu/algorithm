package com.design.method.facade.impl;

import com.design.method.facade.ServiceB;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class ServiceBImpl implements ServiceB {
    @Override
    public void methodB() {
        System.out.println("这只服务B");
    }
}
