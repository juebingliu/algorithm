package com.test;

import com.design.method.facade.Facade;
import com.design.method.facade.ServiceA;
import com.design.method.facade.ServiceB;
import com.design.method.facade.impl.ServiceAImpl;
import com.design.method.facade.impl.ServiceBImpl;

/**
 * Created by juebingliu on 2018/6/11.
 */

/**
 * 通过facade统一入口调用内部系统
 */
public class FacadeTest {
    public static void main(String[] args) {
        ServiceA sa = new ServiceAImpl();
        ServiceB sb = new ServiceBImpl();
        sa.methodA();
        sb.methodB();
        System.out.println("========");
        //facade
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
    }
}
