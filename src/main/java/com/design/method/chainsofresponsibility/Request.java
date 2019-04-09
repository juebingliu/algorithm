package com.design.method.chainsofresponsibility;

/**
 * Created by juebingliu on 2018/6/12.
 */

/**
 * 父类req,实现execute方法即可
 */
public class Request {
    private String type;

    public Request(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public void execute(){

    }
}
