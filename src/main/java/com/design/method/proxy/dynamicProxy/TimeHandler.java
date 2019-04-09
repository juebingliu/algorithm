package com.design.method.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by juebingliu on 2018/6/8.
 */
//事务处理器
public class TimeHandler implements InvocationHandler{
    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * 参数：
     *proxy 被代理的对象
     *method 被代理对象的方法
     *args 方法的参数
     * 返回：
     *Object 方法返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车开始行驶…");
        method.invoke(target,args);
        long stopTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶…汽车行驶时间：" + (stopTime - startTime) + "毫秒！");
        return null;

    }
}