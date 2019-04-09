package com.design.unit.thread.ch02.thread;

import com.design.unit.thread.ch02.Function;

/**
 * Created by juebingliu on 2018/6/19.
 */
public class ThreadB extends Thread {
    private Function f;

    public ThreadB(Function f) {
        super();
        this.f = f;
    }

    @Override
    public void run() {
        super.run();
        f.addI("b");
    }
}
