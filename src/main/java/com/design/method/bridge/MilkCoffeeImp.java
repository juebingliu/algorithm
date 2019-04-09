package com.design.method.bridge;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class MilkCoffeeImp extends CoffeeImp {
    public MilkCoffeeImp() {
    }

    @Override
    public void pourCoffeeImp() {
        System.out.println("加了美味的牛奶");
    }
}
