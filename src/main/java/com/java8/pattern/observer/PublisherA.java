package com.java8.pattern.observer;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:50
 * @description
 */
public class PublisherA implements Observer {
    @Override
    public void notify(String news) {
        if(news != null && news.contains("money")){
            System.out.println("Breaking news in NY! " + news);
        }
    }
}