package com.design.unit.thread.ch03.pandc;

/**
 * Created by juebingliu on 2018/6/28.
 */

/**
 * 消费者
 */
public class C {
    private String lock;

    public C(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                while (ValueObject.value.equals("")){
                    System.out.println("消费者"+Thread.currentThread().getName() +"waiting了！");
                    lock.wait();
                }
                System.out.println("消费者"+Thread.currentThread().getName()+ "runnable了！");
                //String value = System.currentTimeMillis()+"_"+System.nanoTime();
                ValueObject.value = "";
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
