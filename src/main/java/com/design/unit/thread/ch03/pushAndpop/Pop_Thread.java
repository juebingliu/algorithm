package com.design.unit.thread.ch03.pushAndpop;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class Pop_Thread extends Thread {
    private C c;

    public Pop_Thread(C c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.pop();
        }
    }
}
