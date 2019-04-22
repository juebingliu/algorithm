package com.java8.pattern.observer;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:52
 * @description
 */
public class PublisherC implements Observer {
    @Override
    public void notify(String news) {
        if(news != null && news.contains("wine")){
            System.out.println("Today cheese, wine and news! " + news);
        }
    }
}