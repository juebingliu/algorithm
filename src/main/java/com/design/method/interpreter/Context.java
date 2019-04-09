package com.design.method.interpreter;

/**
 * Created by juebingliu on 2018/6/13.
 */
public class Context {
    private String in ;

    private int out ;

    public Context(String in) {
        this.in = in ;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.in = String.valueOf( out ) ;
        this.out = out;
    }

    public String getIn() {
        return in;
    }
}
