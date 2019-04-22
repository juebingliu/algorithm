package com.java8.pattern.observer;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:48
 * @description 观察者
 */
public interface Observer {
    void notify(String news);
}