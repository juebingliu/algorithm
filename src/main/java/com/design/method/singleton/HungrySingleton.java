package com.design.method.singleton;

/**
 * Created by juebingliu on 2018/6/8.
 */

/**
 * 饿汉式单例模式天生的线程安全
 */
public class HungrySingleton {
    public HungrySingleton() {
    }
    private static final HungrySingleton single = new HungrySingleton();
    public static HungrySingleton getInstance(){
        return single;
    }
}
