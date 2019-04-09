package com.design.unit.thread.ch02;

/**
 * Created by juebingliu on 2018/6/20.
 */
public class Run {
    public static void main(String[] args) {
        VolatileTest[] arr = new VolatileTest[100];
        for(int i =0;i<100;i++){
            arr[i]= new VolatileTest();
        }
        for(int i =0;i<100;i++){
            arr[i].start();
        }

    }
}
