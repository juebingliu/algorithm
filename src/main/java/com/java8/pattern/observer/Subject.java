package com.java8.pattern.observer;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:54
 * @description
 */
public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String news);
}