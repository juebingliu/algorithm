package com.design.unit.thread.ch06.serilize;

import java.io.Serializable;

/**
 * Created by juebingliu on 2018/7/3.
 */
public class MyObject implements Serializable {
    private static final long serialVersionUID = -2319292374927084801L;

    private static class MyObejectHandler {
        private static final MyObject myObject = new MyObject();
    }

    public MyObject() {
    }

    public static MyObject getInstatnce(){
        return MyObejectHandler.myObject;
    }

    protected Object readResolve (){
        System.out.println("调用readResolve方法");
        return MyObejectHandler.myObject;
    }

}
