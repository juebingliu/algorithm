package com.design.method.bridge;

/**
 * Created by juebingliu on 2018/6/11.
 */
/**
 * 单例咖啡类
 */
public class CoffeeImpSingleton {
    private static CoffeeImp coffeeImp;
    public CoffeeImpSingleton(CoffeeImp coffeeImpIn) {
        this.coffeeImp = coffeeImpIn;
    }
    public static CoffeeImp getTheCoffeeImp() { return coffeeImp; }
}
