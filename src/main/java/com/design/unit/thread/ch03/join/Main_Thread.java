package com.design.unit.thread.ch03.join;

/**
 * Created by juebingliu on 2018/6/29.
 */
public class Main_Thread extends Thread {
    @Override
    public void run() {
        try {
            Join_Thread jt = new Join_Thread();
            jt.start();
            jt.join();
            System.out.println("main线程在结束处打印");
        } catch (InterruptedException e) {
            System.out.println("main线程在catch处打印");
            e.printStackTrace();
        }
    }
}
