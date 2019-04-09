package com.design.unit.thread.ch03.pipeStream;

import java.io.PipedOutputStream;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
