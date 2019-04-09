package com.design.unit.thread.ch03.pipeStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by juebingliu on 2018/6/28.
 */

/**
 * 管道流可以使字节流，也可以是字符流
 */
public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            outputStream.connect(inputStream);
            //inputStream.connect(outputStream);

            ThreadRead threadRead = new ThreadRead(readData,inputStream);
            threadRead.start();

            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData,outputStream);
            threadWrite.start();
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
