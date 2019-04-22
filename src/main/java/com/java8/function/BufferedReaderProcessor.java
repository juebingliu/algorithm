package com.java8.function;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/22 16:36
 * @description
 */
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}