package com.design.unit;

/**
 * Created by juebingliu on 2018/6/14.
 */
public class ThreadTest {
    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getName());

//        mt.start();
//        System.out.println("运行结束");

        //myThread
//        try {
//            MyThread mt = new MyThread();
//            mt.setName("myThread");
//            mt.start();
//            for(int i=0;i<10;i++){
//                int time = (int) (Math.random()*1000);
//                Thread.sleep(time);
//                System.out.println("main="+Thread.currentThread().getName());
//            }
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

        //myThread1
//        MyThread1 mt1 = new MyThread1(1);
//        MyThread1 mt2 = new MyThread1(2);
//        MyThread1 mt3 = new MyThread1(3);
//        mt1.start();
//        mt2.start();
//        mt3.start();

        //myThread2
//        MyThread2 mt = new MyThread2();
//        Thread t = new Thread(mt);
//        t.start();
//        System.out.println("运行结束");Thread a = new Thread(mt,"a");

        //myThread3 非共享变量
//        MyThread3 a = new MyThread3("a");
//        MyThread3 b = new MyThread3("b");
//        MyThread3 c = new MyThread3("c");
//        a.start();
//        b.start();
//        c.start();

        //myThread5 共享变量
//        MyThread5 mt = new MyThread5();
//        Thread a = new Thread(mt,"a");
//        Thread b = new Thread(mt,"b");
//        Thread c = new Thread(mt,"c");
//        Thread d = new Thread(mt,"d");
//        Thread e = new Thread(mt,"e");
//        a.start();
//        b.start();
//        c.start();
//        d.start();
//        e.start();

        //线程中断
//        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setDaemon(true);
//        Thread.currentThread().interrupt();
//        System.out.println(Thread.currentThread().isInterrupted());
//        System.out.println(Thread.interrupted());
//        System.out.println(Thread.currentThread().isInterrupted());
//        System.out.println(Thread.interrupted());

        //脏读
//        try {
//            MethodA m = new MethodA();
//            ThreadA threadA = new ThreadA(m);
//            threadA.start();
//            threadA.sleep(200);
//            m.getValue();
//        }catch (InterruptedException e ){
//            e.printStackTrace();
//        }

        //String常量池缓存
        String a = new String ("a");
        String b = new String("a");
        System.out.println(a == b);
    }
}
