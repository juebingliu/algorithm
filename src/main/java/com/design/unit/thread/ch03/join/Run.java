package com.design.unit.thread.ch03.join;

/**
 * Created by juebingliu on 2018/6/29.
 */
public class Run {
    public static void main(String[] args) {
        try {
            Main_Thread m = new Main_Thread();
            m.start();
            Thread.sleep(5000);
            Run_Thread r = new Run_Thread(m);
            r.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
