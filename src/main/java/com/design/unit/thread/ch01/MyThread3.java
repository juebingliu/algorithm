package com.design.unit.thread.ch01;

/**
 * Created by juebingliu on 2018/6/14.
 */
public class MyThread3 extends Thread {
    private int count = 5;

    public MyThread3(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count>0) {
            count--;
            System.out.println("由"+this.currentThread().getName()+"计算.count="+count);
        }
    }
}
