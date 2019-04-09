package com.design.method.proxy.staticProxy;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class AdminProxy extends Admin{
    @Override
    public void doSomething() {
        System.out.println("Log:admin操作开始");
        super.doSomething();
        System.out.println("Log:admin操作开始");
    }
}
