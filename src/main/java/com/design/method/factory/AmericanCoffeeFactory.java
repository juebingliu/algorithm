package com.design.method.factory;

import com.design.method.factory.init.Americano;
import com.design.method.factory.init.Latte;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class AmericanCoffeeFactory extends CoffeeFactory {
    public Coffee[] createCoffee() {
        return new Coffee[]{new Americano(),new Latte()};
    }
}
