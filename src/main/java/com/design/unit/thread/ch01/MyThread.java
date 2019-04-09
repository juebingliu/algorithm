package com.design.unit.thread.ch01;

/**
 * Created by juebingliu on 2018/6/14.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try {
        for(int i=0;i<10;i++){
            int time = (int) (Math.random()*1000);
            Thread.sleep(time);
            System.out.println("run="+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
