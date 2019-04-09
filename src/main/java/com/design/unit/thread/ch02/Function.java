package com.design.unit.thread.ch02;

/**
 * Created by juebingliu on 2018/6/19.
 */
public class Function {
    public void addI(String userName){

        try {
            int num = 0;
            if (userName.equals("a")) {
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            }else {
                num =200;
                System.out.println("b set over");
            }
            System.out.println(userName +" num=" +num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
