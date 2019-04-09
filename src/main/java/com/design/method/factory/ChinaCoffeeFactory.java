package com.design.method.factory;

import com.design.method.factory.init.Cappuccino;
import com.design.method.factory.init.Latte;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class ChinaCoffeeFactory extends CoffeeFactory {
    public Coffee[] createCoffee() {
        return new Coffee[]{new Cappuccino(),new Latte()};
    }
}
