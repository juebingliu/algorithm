package com.design.unit.thread.ch01;

/**
 * Created by juebingliu on 2018/6/14.
 */
public class MyThread1 extends Thread {
    private int i;

    public MyThread1(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}
