package com.design.unit.thread.ch04.pandc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by juebingliu on 2018/7/2.
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue == true){
                condition.await();
            }

            System.out.println("生产者打印A");
            hasValue = true;
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while (hasValue == false){
                condition.await();
            }

            System.out.println("消费者打印A");
            hasValue = false;
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
