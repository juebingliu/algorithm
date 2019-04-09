package com.design.method.template;

/**
 * Created by juebingliu on 2018/6/12.
 */

/**
 * 父类方法延迟到子类执行
 */
public class MethodBenchmark extends Benchmark {
    @Override
    public void benchmark() {
        for (int i = 0; i < Integer.MAX_VALUE; i++)
            System.out.println("i="+i);
    }
}
