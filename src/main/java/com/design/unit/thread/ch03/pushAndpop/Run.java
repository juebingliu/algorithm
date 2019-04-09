package com.design.unit.thread.ch03.pushAndpop;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class Run {
    public static void main(String[] args) {
        Queue q = new Queue();

        P p = new P(q);
        C c = new C(q);

        Push_Thread pushThread = new Push_Thread(p);
        Pop_Thread popThread = new Pop_Thread(c);

        pushThread.start();
        popThread.start();
    }
}
