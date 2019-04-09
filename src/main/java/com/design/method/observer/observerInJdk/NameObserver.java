package com.design.method.observer.observerInJdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class NameObserver implements Observer {

    private String name = null;

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String){
            name = (String) arg;
            System.out.println("NameObserver :name changed to"+name);
        }
    }
}
