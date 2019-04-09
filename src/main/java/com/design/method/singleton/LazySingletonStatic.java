package com.design.method.singleton;

/**
 * Created by juebingliu on 2018/6/8.
 */

/**
 * 用静态对象生成单例确保线程安全
 */
public class LazySingletonStatic {
    public LazySingletonStatic() {
    }
    private static class  lazyHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    private static final LazySingleton getInstance(){
        return lazyHolder.INSTANCE;
    }
}
