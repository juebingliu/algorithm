package com.design.unit.thread.ch03.pushAndpop;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class Push_Thread extends Thread{
    private P p;

    public Push_Thread(P p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.push();
        }
    }
}
