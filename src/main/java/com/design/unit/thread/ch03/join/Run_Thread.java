package com.design.unit.thread.ch03.join;

/**
 * Created by juebingliu on 2018/6/29.
 */
public class Run_Thread extends Thread {
    private Main_Thread main_thread;

    public Run_Thread(Main_Thread main_thread) {
        super();
        this.main_thread = main_thread;
    }

    @Override
    public void run() {
        main_thread.interrupt();
    }
}
