package com.design.method.factory;

/**
 * Created by juebingliu on 2018/6/8.
 */

/**
 * 抽象工厂
 */
public interface AbstractDrinksFactory {
    /**
     * 制造咖啡
     * @return
     */
    Coffee createCoffee();

    /**
     * 制造茶
     * @return
     */
    Tea createTea();

    /**
     * 制造碳酸饮料
     * @return
     */
    Sodas createSodas();
}
