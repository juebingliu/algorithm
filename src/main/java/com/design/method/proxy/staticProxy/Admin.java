package com.design.method.proxy.staticProxy;

/**
 * Created by juebingliu on 2018/6/8.
 */
//真实主题类
public class Admin implements Manager{
    @Override
    public void doSomething() {
        System.out.println("Admin do something.");
    }
}
