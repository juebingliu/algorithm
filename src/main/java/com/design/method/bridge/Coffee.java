package com.design.method.bridge;

/**
 * Created by juebingliu on 2018/6/11.
 */
public abstract class Coffee {
    CoffeeImp coffeeImp;
    public void setCoffeeImp() {
        this.coffeeImp = CoffeeImpSingleton.getTheCoffeeImp();
    }
    public CoffeeImp getCoffeeImp() {return this.coffeeImp;}
    public abstract void pourCoffee();
}
