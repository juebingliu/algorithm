package com.design.method.chainsofresponsibility;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class RequestA extends Request {
    public RequestA(String type) {
        super(type);
        System.out.println("这是A请求");
    }

    @Override
    public void execute() {
        System.out.println("响应A请求");
    }
}
