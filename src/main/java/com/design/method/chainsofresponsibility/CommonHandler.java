package com.design.method.chainsofresponsibility;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class CommonHandler implements Handler {
    @Override
    public void handleRequest(Request request) {
        if(request instanceof RequestC){
            request.execute();
        }
        System.out.println("处理完毕");
    }
}
