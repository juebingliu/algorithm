package com.design.method.interpreter;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class MinusExpression extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        String in = context.getIn();
        int v = Integer.parseInt(in);
        context.setOut(--v);
    }
}
