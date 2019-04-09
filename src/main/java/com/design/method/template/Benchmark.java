package com.design.method.template;

/**
 * Created by juebingliu on 2018/6/12.
 */
public abstract class Benchmark {

    /**
     * 下面操作是我们希望在子类中完成
     */
    public abstract void benchmark();

    public final long repeat(int count) {
        if(count <= 0)
            return 0;
        else{
            long startTime = System.currentTimeMillis();
            for(int i=0; i<count; i++)
                benchmark();
            long stopTime = System.currentTimeMillis();
            return stopTime-startTime;
        }
    }
}
