package com.design.method.mediator;

/**
 * Created by juebingliu on 2018/6/12.
 */
public abstract class Person {
    // 维持一个抽象中介者的引用
    protected Mediator mediator;

    protected String name;

    public Person(String name, Mediator mediator){
        this.mediator = mediator;
        this.name = name;
    }

    /**
     * 设置中介者对象
     * @param mediator
     */
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }

    /**
     * 向中介 发送消息
     */
    public abstract void sendMessage(String msg);

    /**
     * 从中介 获取消息
     */
    protected abstract void getMessage(String msg);
}
