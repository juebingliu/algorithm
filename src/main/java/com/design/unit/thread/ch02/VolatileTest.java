package com.design.unit.thread.ch02;

/**
 * Created by juebingliu on 2018/6/20.
 */
public class VolatileTest extends Thread{
    volatile public static int count;
    private static void addCount() {
        for(int i = 0;i<100;i++){
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
