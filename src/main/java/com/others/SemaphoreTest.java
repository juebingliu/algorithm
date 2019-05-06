package com.others;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/6 10:56
 * @description 信号量测试
 */
public class SemaphoreTest {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        final Semaphore sem = new Semaphore(5,true);
        for (int index = 0; index < 20; index++) {
            Runnable r = () -> {
                try {
                    //获得许可
                    sem.acquire();
                    System.out.println("剩余许可：" + sem.availablePermits());
                    Thread.sleep((long) Math.random());
                    sem.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(r);
        }
        exec.shutdown();
    }
}