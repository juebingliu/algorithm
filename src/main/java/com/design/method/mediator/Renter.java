package com.design.method.mediator;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class Renter extends Person {
    public Renter(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void sendMessage(String msg) {
        mediator.operation(this, msg);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("求租者[" + name + "]收到中介发来的消息： " + msg);
    }
}
