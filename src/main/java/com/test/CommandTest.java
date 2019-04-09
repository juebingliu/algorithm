package com.test;


import com.design.method.command.Command;
import com.design.method.command.Producer;

import java.util.Iterator;
import java.util.List;

/**
 * Created by juebingliu on 2018/6/11.
 */

/**
 * 接口调用中间层
 */
public class CommandTest {
    public static void main(String[] args) {
        List queue = Producer.produceRequests();
        for(Iterator it = queue.iterator(); it.hasNext();)
            //客户端直接调用execute方法，无需知道被调用者的其它更多类的方法名。
            ((Command)it.next()).execute();
    }
}
