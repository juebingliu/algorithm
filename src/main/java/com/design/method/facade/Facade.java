package com.design.method.facade;

import com.design.method.facade.impl.ServiceAImpl;
import com.design.method.facade.impl.ServiceBImpl;
import com.design.method.facade.impl.ServiceCImpl;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class Facade {
    ServiceA sa;
    ServiceB sb;
    ServiceC sc;
    public Facade() {
        sa = new ServiceAImpl();
        sb = new ServiceBImpl();
        sc = new ServiceCImpl();
    }

    public void methodA() {
        sa.methodA();
        sb.methodB();
    }

    public void methodB() {
        sb.methodB();
        sc.methodC();
    }

    public void methodC() {
        sc.methodC();
        sa.methodA();
    }
}
