package com.test;

import com.design.method.template.Benchmark;
import com.design.method.template.MethodBenchmark;

/**
 * Created by juebingliu on 2018/6/12.
 */
public class TemplateTest {
    public static void main(String[] args) {
        Benchmark operation = new MethodBenchmark();
        long duration = operation.repeat(10);
        System.out.println("The operation took " + duration + " milliseconds");
    }
}
