package com.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author juebing
 * @date 2018/11/16 16:33
 * @description
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executor;

    /**
     * 创建一个socket服务器处理线程池
     * @param maxPoolSize
     * @param queueSize
     */
    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L,
                TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }
}