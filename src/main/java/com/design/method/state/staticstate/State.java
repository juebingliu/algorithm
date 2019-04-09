package com.design.method.state.staticstate;

/**
 * Created by juebingliu on 2018/6/13.
 */
public abstract class State {
    public abstract void on(Switch s);
    public abstract void off(Switch s);
}
