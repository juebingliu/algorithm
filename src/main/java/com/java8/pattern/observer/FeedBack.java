package com.java8.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:55
 * @description
 */
public class FeedBack implements Subject{
    private final List<Observer> list = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void notifyObservers(String news) {
        list.forEach(o -> o.notify(news));
    }
}