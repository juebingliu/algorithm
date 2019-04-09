package com.design.unit.thread.ch03.pipeStream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by juebingliu on 2018/6/28.
 */
public class ReadData {
    public void readMethod(PipedInputStream input){
        try {
            System.out.println("read:");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1){
                String newData = new String(byteArray,0,readLength);
                System.out.println(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
