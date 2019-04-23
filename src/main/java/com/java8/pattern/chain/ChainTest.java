package com.java8.pattern.chain;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/23 10:55
 * @description lambda链式
 */
public class ChainTest {
    public static void main(String[] args) {
        UnaryOperator<String> first = (String text) -> "it is first operation" + text;

        UnaryOperator<String> second = (String text) -> text.replace("aaa","bbb");

        Function<String,String> pipe = first.andThen(second);

        System.out.println(pipe.apply(" aaa bbbbbcc"));
    }
}