package com.test;

import com.design.method.observer.observerInJdk.NameObserver;
import com.design.method.observer.observerInJdk.PriceObserver;
import com.design.method.observer.observerInJdk.Product;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class ObserverTest {
    public static void main(String[] args) {
        //接口实现方式下的观察者模式
//        Subject sub = new MySubject();
//        sub.add(new Observer1());
//        sub.add(new Observer2());
//
//        sub.operation();
        //jdk自带观察者模式
        Product p = new Product();
        NameObserver no = new NameObserver();
        PriceObserver po = new PriceObserver();
        p.addObserver(no);
        p.addObserver(po);
        p.setName("橘子");
        p.setPrice(5.0f);
    }
}
