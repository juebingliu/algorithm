package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/27 14:28
 * @description 利用cas实现锁
 */
public class MyLock {
    private AtomicInteger status = new AtomicInteger(0);
    public void lock() {
        while(!status.compareAndSet(0,1)) {
            Thread.yield();
        }
    }
    public void unlock() {
        status.compareAndSet(1,0);
    }

    public static void main(String[] args) {

    }
}