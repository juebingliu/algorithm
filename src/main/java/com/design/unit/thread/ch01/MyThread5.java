package com.design.unit.thread.ch01;

/**
 * Created by juebingliu on 2018/6/15.
 */
public class MyThread5 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        synchronized (this){
            count--;
        }
        System.out.println("由"+this.currentThread().getName()+"计算.count="+count);
    }
}
