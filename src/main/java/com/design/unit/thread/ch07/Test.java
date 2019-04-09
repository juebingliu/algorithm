package com.design.unit.thread.ch07;

/**
 * Created by juebingliu on 2018/7/3.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("A处线程："+Thread.currentThread().getName()+"所属的线程名为："+Thread.currentThread().getThreadGroup().getName()+"中有线程组数量："+Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup group =new ThreadGroup("新的组");
        System.out.println("B处线程："+Thread.currentThread().getName()+"所属的线程名为："+Thread.currentThread().getThreadGroup().getName()+"中有线程组数量："+Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGroup);

        for (int i = 0;i<threadGroup.length;i++){
            System.out.println("第一个线程租的名称为："+threadGroup[i].getName());
        }
    }
}
