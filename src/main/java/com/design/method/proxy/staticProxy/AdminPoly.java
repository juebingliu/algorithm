package com.design.method.proxy.staticProxy;

/**
 * Created by juebingliu on 2018/6/8.
 */
//聚合方式实现代理主题
public class AdminPoly implements Manager{
    private Admin admin;

    public AdminPoly(Admin admin) {
        super();
        this.admin = admin;
    }

    @Override
    public void doSomething() {
        System.out.println("Log:admin操作开始");
        admin.doSomething();
        System.out.println("Log:admin操作结束");
    }
}
