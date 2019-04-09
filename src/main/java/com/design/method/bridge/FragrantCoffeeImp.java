package com.design.method.bridge;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class FragrantCoffeeImp extends CoffeeImp {
    public FragrantCoffeeImp() {
    }

    @Override
    public void pourCoffeeImp() {
        System.out.println("什么也没加,清香");
    }
}
