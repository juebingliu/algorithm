package com.design.unit.thread.ch03.pandc;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class ThreadP extends Thread {

    private P p;

    public ThreadP(P p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
