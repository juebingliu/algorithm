package com.design.method.factory;

import com.design.method.factory.init.Americano;
import com.design.method.factory.init.Cappuccino;
import com.design.method.factory.init.Latte;

/**
 * Created by juebingliu on 2018/6/8.
 */

/**
 * 简单工厂
 */
public class SimpleFactory {

    /**
     * 通过类型获取Coffee实例对象
     * @param type 咖啡类型
     * @return
     */
    public static Coffee createInstance(String type){
        if("americano".equals(type)){
            return new Americano();
        }else if("cappuccino".equals(type)){
            return new Cappuccino();
        }else if("latte".equals(type)){
            return new Latte();
        }else{
            throw new RuntimeException("type["+type+"]类型不可识别，没有匹配到可实例化的对象！");
        }
    }

    public static void main(String[] args) {
        Coffee latte = SimpleFactory.createInstance("latte");
        System.out.println("创建的咖啡实例为:" + latte.getName());
        Coffee cappuccino = SimpleFactory.createInstance("cappuccino");
        System.out.println("创建的咖啡实例为:" + cappuccino.getName());
    }
}
