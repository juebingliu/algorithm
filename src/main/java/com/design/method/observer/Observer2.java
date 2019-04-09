package com.design.method.observer;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class Observer2 implements Observer {
    @Override
    public void update() {
        System.out.println("observer2 has received!");
    }
}
