package com.design.method.memento;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento(){
        return this.memento;
    }

    public void setMemento(Memento memento){
        this.memento = memento;
    }
}
