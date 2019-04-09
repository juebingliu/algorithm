package com.design.method.mediator;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class Landlord extends Person {

    public Landlord(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void sendMessage(String msg) {
        mediator.operation(this, msg);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("房东["+ name +"]收到中介发来的消息：" + msg);
    }
}
