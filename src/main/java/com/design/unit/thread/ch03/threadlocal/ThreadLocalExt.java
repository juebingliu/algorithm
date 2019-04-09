package com.design.unit.thread.ch03.threadlocal;

/**
 * Created by juebingliu on 2018/7/2.
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "";
    }
}
