package com.design.unit.thread.ch06.singleton;

/**
 * Created by juebingliu on 2018/7/3.
 */
public class MyObject {
    private static MyObject myObject = new MyObject();

    public MyObject() {
    }

    public static MyObject getInstance(){
        return myObject;
    }
}
