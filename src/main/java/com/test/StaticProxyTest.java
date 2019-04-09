package com.test;

import com.design.method.proxy.staticProxy.Admin;
import com.design.method.proxy.staticProxy.AdminPoly;
import com.design.method.proxy.staticProxy.AdminProxy;
import com.design.method.proxy.staticProxy.Manager;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //聚合代理
        Admin admin = new Admin();
        Manager m = new AdminPoly(admin);
        m.doSomething();
        //继承式代理
        AdminProxy proxy = new AdminProxy();
        proxy.doSomething();
    }
}
