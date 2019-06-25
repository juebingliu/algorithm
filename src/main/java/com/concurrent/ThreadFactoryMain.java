package com.concurrent;

import com.sun.istack.internal.NotNull;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/6/25 15:15
 * @description 自定义线程池
 */
public class ThreadFactoryMain implements ThreadFactory {

    private final String groupName;
    private AtomicInteger nextId = new AtomicInteger(1);

    public ThreadFactoryMain(String groupName) {
        this.groupName = "ThreadFactoryMain -" + groupName + " -worker-";
    }

    @Override
    public Thread newThread(@NotNull Runnable r) {
        String threadName = groupName + nextId.incrementAndGet();
        Thread thread = new Thread(null,r,threadName,0);
        return thread;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,50,60L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(20),new ThreadFactoryMain("juebing.test"));
        //预先启动所有核心线程池
        threadPoolExecutor.prestartAllCoreThreads();

        Stream.iterate(0,n -> n+1)
                .limit(10)
                .forEach(i -> threadPoolExecutor.submit(() ->{
                    System.out.println(Thread.currentThread().getName()+ "::: ---" +i);
                }));
        System.out.println("end");
        threadPoolExecutor.shutdown();
    }
}