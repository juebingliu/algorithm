package com.test;

import com.design.method.bridge.*;

/**
 * Created by juebingliu on 2018/6/11.
 */
public class BridgeTest {

    public static void main(String[] args) {
        CoffeeImpSingleton coffeeImpSingleton = new CoffeeImpSingleton(new FragrantCoffeeImp());

        MediumCoffee mediumCoffee = new MediumCoffee();
        mediumCoffee.pourCoffee();

        SuperSizeCoffee superSizeCoffee = new SuperSizeCoffee();
        superSizeCoffee.pourCoffee();
    }
}
