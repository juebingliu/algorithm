package com.design.method.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class Producer {
    public static List produceRequests() {
        List queue = new ArrayList();
        queue.add( new Engineer() );
        queue.add( new Politician() );
        queue.add( new Programmer() );
        return queue;
    }
}
