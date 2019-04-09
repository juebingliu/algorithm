package com.design.unit.thread.ch03.pandc;

/**
 * Created by juebingliu on 2018/6/28.
 */

/**
 * 生产者
 */
public class P {
    private String lock;

    public P(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue( ){
        try {
            synchronized (lock){
                while (!ValueObject.value.equals("")){
                    System.out.println("生产者"+Thread.currentThread().getName() +"waiting了！");
                    lock.wait();
                }
                System.out.println("生产者"+Thread.currentThread().getName()+ "runnable了！");
                String value = System.currentTimeMillis()+"_"+System.nanoTime();
                ValueObject.value = value;
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
