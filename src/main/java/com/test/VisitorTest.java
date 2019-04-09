package com.test;

import com.design.method.visitor.ConcreteVisitor;
import com.design.method.visitor.FloatElement;
import com.design.method.visitor.StringElement;
import com.design.method.visitor.Visitor;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class VisitorTest {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        StringElement stringE = new StringElement("I am a String");
        visitor.visitString(stringE);
        Collection list = new ArrayList();
        list.add(new StringElement("I am a String1"));
        list.add(new StringElement("I am a String2"));
        list.add(new FloatElement(new Float(12)));
        list.add(new StringElement("I am a String3"));
        visitor.visitCollection(list);
    }
}
