package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/6/26 17:22
 * @description
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),new ThreadFactoryMain("thread.test"),new ThreadPoolExecutor.DiscardOldestPolicy());

        Stream.iterate(0, n -> n+1)
                .limit(20)
                .forEach(i -> threadPoolExecutor.submit(() -> {
                    System.out.println(Thread.currentThread().getName()+ "::: ---" +i);
                }));
        threadPoolExecutor.shutdown();

    }
}