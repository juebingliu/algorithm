package com.design.unit.thread.ch02.thread;

import com.design.unit.thread.ch02.Function;

/**
 * Created by juebingliu on 2018/6/19.
 */
public class ThreadA extends Thread {
    private Function f;

    public ThreadA(Function f) {
        super();
        this.f = f;
    }

    @Override
    public void run() {
        super.run();
        f.addI("a");
    }
}
