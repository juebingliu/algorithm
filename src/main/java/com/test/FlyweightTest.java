package com.test;

import com.design.method.flyweight.Flyweight;
import com.design.method.flyweight.FlyweightFactory;

/**
 * Created by juebingliu on 2018/6/11.
 */

/**
 * 类似连接池实现方法
 */
public class FlyweightTest {
    public static void main(String[] args) {
        Flyweight fly1 = FlyweightFactory.getFlyweight("a");
        fly1.action(1);

        Flyweight fly2 = FlyweightFactory.getFlyweight("a");
        System.out.println(fly1 == fly2);

        Flyweight fly3 = FlyweightFactory.getFlyweight("b");
        fly3.action(2);

        Flyweight fly4 = FlyweightFactory.getFlyweight("c");
        fly4.action(3);

        Flyweight fly5 = FlyweightFactory.getFlyweight("d");
        fly4.action(4);

        System.out.println(FlyweightFactory.getSize());
    }
}
