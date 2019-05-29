package com.concurrent;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/29 11:00
 * @description executor demo
 */
public class BasicDemo {

    static Callable<Integer> task = () -> {
        int sleepSeconfd = new Random().nextInt(1000);
        Thread.sleep(sleepSeconfd);
        return sleepSeconfd;
    };

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);
        Thread.sleep(100);
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}