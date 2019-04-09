package com.design.unit.thread.ch06.singleton;

/**
 * Created by juebingliu on 2018/7/3.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
