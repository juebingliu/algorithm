package com.design.method.visitor;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visitString(StringElement stringE) {
        System.out.println("'"+stringE.getValue()+"'");
    }

    @Override
    public void visitFloat(FloatElement floatE) {
        System.out.println(floatE.getValue().toString()+"f");
    }

    @Override
    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Visitable)
                ((Visitable) o).accept(this);
        }
    }
}
