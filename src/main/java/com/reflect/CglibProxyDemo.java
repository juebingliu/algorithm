package com.reflect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/30 19:17
 * @description
 */
public class CglibProxyDemo {
    static class RealService {
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = methodProxy.invokeSuper(o,objects);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    private static <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        RealService proxyService = getProxy(RealService.class);
        proxyService.sayHello();
    }
}