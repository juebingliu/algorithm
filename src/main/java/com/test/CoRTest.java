package com.test;

import com.design.method.chainsofresponsibility.*;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class CoRTest {

    public static void main(String[] args) {
        RequestA ra = new RequestA("A");
        RequestB rb = new RequestB("B");
        RequestC rc = new RequestC("C");

        CommonHandler ch = new CommonHandler();
        ConcreteHandler ch1 = new ConcreteHandler(ch);

        ch1.handleRequest(ra);

        ch1.handleRequest(rb);

        ch1.handleRequest(rc);
    }
}
