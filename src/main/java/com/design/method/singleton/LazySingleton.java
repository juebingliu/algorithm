package com.design.method.singleton;

/**
 * Created by juebingliu on 2018/6/8.
 */

/**
 * 懒汉单例模式
 */
public class LazySingleton {
    public LazySingleton() {
    }
    private static LazySingleton lazySingleton = null;

    /**
     * 非线程安全
     * @return
     */
    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**
     * 加同步锁确保线程安全
     * @return
     */
    public static synchronized LazySingleton getInstanceThreadLock(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    /**
     * 双重检查保证线程安全
     * @return
     */
    public static LazySingleton getInstanceDoubleLock(){
        if(lazySingleton == null){
            synchronized (LazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
