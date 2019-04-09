package com.design.unit.thread.ch03.pandc;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
