package com.design.method.chainsofresponsibility;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class RequestC extends Request {
    public RequestC(String type) {
        super(type);
        System.out.println("这是C请求");
    }

    @Override
    public void execute() {
        System.out.println("响应C请求");
    }
}
