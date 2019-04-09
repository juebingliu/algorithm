package com.design.method.chainsofresponsibility;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class RequestB extends Request {
    public RequestB(String type) {
        super(type);
        System.out.println("这是B请求");
    }

    @Override
    public void execute() {
        System.out.println("响应B请求");
    }
}
