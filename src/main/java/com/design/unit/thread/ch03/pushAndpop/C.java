package com.design.unit.thread.ch03.pushAndpop;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class C {
    private Queue q;

    public C(Queue q) {
        super();
        this.q = q;
    }
    public void pop() {
        System.out.println("pop+" + q.pop());
    }
}
