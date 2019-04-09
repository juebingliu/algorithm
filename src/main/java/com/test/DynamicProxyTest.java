package com.test;

import com.design.method.proxy.dynamicProxy.Car;
import com.design.method.proxy.dynamicProxy.Moveable;
import com.design.method.proxy.dynamicProxy.TimeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class DynamicProxyTest {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();
        /**
         *loader 类加载器
         *interfaces 实现接口
         *h InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(), h);
        m.move();
    }
}
