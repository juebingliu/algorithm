package com.design.unit.thread.ch04.pandc;

/**
 * Created by juebingliu on 2018/7/2.
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.start();
        ThreadB b = new ThreadB(myService);
        b.start();
    }
}
