package com.design.unit.thread.ch04.pandc;

/**
 * Created by juebingliu on 2018/7/2.
 */
public class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i =9;i<Integer.MAX_VALUE;i++){
            myService.set();
        }
    }
}
