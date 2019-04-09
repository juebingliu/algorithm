package com.design.method.visitor;

/**
 * Created by juebingliu on 2018/6/13.
 */
public interface Visitable {
    public void accept(Visitor visitor);
}
