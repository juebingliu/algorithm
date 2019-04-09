package com.design.method.observer;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
