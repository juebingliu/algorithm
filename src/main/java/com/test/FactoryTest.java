package com.test;

import com.design.method.factory.AmericanCoffeeFactory;
import com.design.method.factory.ChinaCoffeeFactory;
import com.design.method.factory.Coffee;
import com.design.method.factory.CoffeeFactory;

/**
 * Created by juebingliu on 2018/6/8.
 */
public class FactoryTest {

    static void print(Coffee[] c){
        for (Coffee coffee : c) {
            System.out.println(coffee.getName());
        }
    }

    public static void main(String[] args) {
        CoffeeFactory chinaCoffeeFactory = new ChinaCoffeeFactory();
        Coffee[] chinaCoffees = chinaCoffeeFactory.createCoffee();
        System.out.println("中国咖啡工厂可以生产的咖啡有：");
        print(chinaCoffees);
        CoffeeFactory americaCoffeeFactory = new AmericanCoffeeFactory();
        Coffee[] americaCoffees = americaCoffeeFactory.createCoffee();
        System.out.println("美国咖啡工厂可以生产的咖啡有：");
        print(americaCoffees);
    }
}
