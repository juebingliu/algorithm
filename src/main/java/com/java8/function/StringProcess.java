package com.java8.function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 17:03
 * @description
 */
public class StringProcess {

    public static void main(String[] args) throws Exception{
        String oneLine = StringProcess.processFile((BufferedReader b) -> b.readLine());
        String twoLine = StringProcess.processFile((BufferedReader b) -> b.readLine() + b.readLine());
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("D:/key.txt"))){
        return p.process(br);
    }
}
}