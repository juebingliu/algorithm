package com.design.unit.thread.ch03.pushAndpop;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class P {
    private Queue q;

    public P(Queue q) {
        super();
        this.q = q;
    }
    public void push() {
        q.push();
    }
}
