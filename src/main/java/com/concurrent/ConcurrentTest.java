package com.concurrent;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/23 17:21
 * @description
 */
public class ConcurrentTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                System.out.println(System.currentTimeMillis());
                Thread.sleep(0);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getId()+" "+Thread.currentThread().getState()+" "+Thread.currentThread().isAlive());
        };
        Thread t = new Thread(r);
        t.start();
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getId());
    }
}