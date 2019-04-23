package com.java8.pattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/23 14:43
 * @description
 */
public class FruitFactory {
    final static Map<String, Supplier<Fruit>> map = new HashMap<>();
    static {
        map.put("pear", Pear::new);
        map.put("pineapple", Pineapple::new);
        map.put("banana", Banana::new);
    }
    public static Fruit createProduct(String name){
        Supplier<Fruit> p = map.get(name);
        if(p != null) {return p.get();}
        throw new IllegalArgumentException("No such product " + name);
    }
}