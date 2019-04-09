package com.design.method.observer.observerInJdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class PriceObserver implements Observer {

    private float price = 0;

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Float){
            price = ((Float) arg).floatValue();
            System.out.println("PriceObserver :price changed to "+price);
        }
    }
}
