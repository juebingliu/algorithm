package com.java8.function;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/16 15:54
 * @description
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest.createList().stream().filter((Product p) -> p.getPrice() > 300).forEach((Product pp) -> System.out.println(pp.getName()) );

        FunctionTest.createList().stream().filter((Product p) -> p.getPrice() > 300).map((Product p) -> p.getPrice()+50).forEach((Integer i) -> System.out.println(i));

        System.out.println(FunctionTest.createList().stream().max(Comparator.comparing(Product::getPrice)).get().getName());

        FunctionTest.createList().sort(Comparator.comparing(Product::getPrice).reversed().thenComparing(Product::getName));
    }

    public static List<Product> createList() {
        Product[] p = {
            new Product("A",100),
            new Product("B",200),
            new Product("C",300),
            new Product("D",400),
            new Product("E",500)
         };
        List<Product> list = Arrays.asList(p);
        return list;
    }
}