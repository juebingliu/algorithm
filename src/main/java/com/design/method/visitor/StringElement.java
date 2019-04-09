package com.design.method.visitor;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class StringElement implements Visitable {

    private String value;

    public StringElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitString(this);
    }
}
