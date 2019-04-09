package com.design.unit.thread.ch03.waitAndnotify;

/**
 * Created by juebingliu on 2018/6/27.
 */
public class Add {
    private String lock;

    public Add(String lock) {
        super();
        this.lock = lock;
    }

    public void add() {
        synchronized (lock){
            
        }

    }
}
