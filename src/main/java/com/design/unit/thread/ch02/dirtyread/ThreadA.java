package com.design.unit.thread.ch02.dirtyread;

/**
 * Created by juebingliu on 2018/6/19.
 */
public class ThreadA extends Thread{
    private MethodA m;

    public ThreadA(MethodA m) {
        super();
        this.m = m;
    }

    @Override
    public void run() {
        super.run();
        m.setValue("B","BB");
    }
}
