package com.design.method.chainsofresponsibility;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class ConcreteHandler implements Handler {

    private Handler successor;

    public ConcreteHandler(Handler successor) {
        this.successor = successor;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof RequestA){
            System.out.println("接收到A请求");
            request.execute();
        } else if(request instanceof RequestB) {
            System.out.println("接收到B请求");
            request.execute();
        } else{
            successor.handleRequest(request);
        }
    }
}
