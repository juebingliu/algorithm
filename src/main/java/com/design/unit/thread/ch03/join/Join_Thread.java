package com.design.unit.thread.ch03.join;

/**
 * Created by juebingliu on 2018/6/29.
 */
public class Join_Thread extends Thread {
    @Override
    public void run() {
        for(int i=0;i< Integer.MAX_VALUE;i++){
            String str = new String();
            Math.random();
        }
    }
}
