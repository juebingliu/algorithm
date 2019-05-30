package com.reflect;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/30 18:15
 * @description 静态代理demo
 */
public class SilenceProxyDemo {
    static interface IService {
        void sayHello();
    }

    static class RealService implements IService{

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class TraceProxy implements IService {

        private IService realService;
        public TraceProxy(IService realService) {
            this.realService = realService;
        }

        @Override
        public void sayHello() {
            System.out.println("entering sayHello");
            this.realService.sayHello();
            System.out.println("leaving sayHello");
        }
    }

    public static void main(String[] args) {
        IService realService = new RealService();
        IService proxyService= new TraceProxy(realService);
        proxyService.sayHello();
    }
}