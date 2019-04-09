package com.design.method.facade.impl;

import com.design.method.facade.ServiceA;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class ServiceAImpl implements ServiceA{
    @Override
    public void methodA() {
        System.out.println("这只服务A");
    }
}
