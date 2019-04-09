package com.design.method.visitor;

import java.util.Collection;

/**
 * Created by juebingliu on 2018/6/13.
 */
public interface Visitor {
    public void visitString(StringElement stringE);
    public void visitFloat(FloatElement floatE);
    public void visitCollection(Collection collection);
}
