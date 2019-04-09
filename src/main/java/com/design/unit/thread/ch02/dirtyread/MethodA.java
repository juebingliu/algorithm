package com.design.unit.thread.ch02.dirtyread;

/**
 * Created by juebingliu on 2018/6/19.
 */
public class MethodA {
    public String username = "A";
    public String password = "AA";

    synchronized  public void setValue(String username ,String password){
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thread name="+Thread.currentThread().getName() +" username="
            + username + " password="+ password);
        } catch (InterruptedException e ){
            e.printStackTrace();
        }
    }

    synchronized public void getValue(){
        System.out.println("setValue method thread name="+Thread.currentThread().getName() +" username="
                + username + " password="+ password);
    }
}
