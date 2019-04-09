package com.design.method.visitor;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class FloatElement implements Visitable {

    private Float value;

    public FloatElement(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFloat(this);
    }
}
