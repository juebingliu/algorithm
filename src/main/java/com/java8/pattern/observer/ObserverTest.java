package com.java8.pattern.observer;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 18:58
 * @description
 */
public class ObserverTest {
    public static void main(String[] args) {
        FeedBack f = new FeedBack();
        f.registerObserver((String s) -> {
            if(s != null && s.contains("queen")) {
                System.out.println("Yet another news in London... " + s);
            }
        });
        f.registerObserver(new PublisherC());
        f.registerObserver(new PublisherA());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}