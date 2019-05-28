package com.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/28 17:23
 * @description
 */
public class MapTest {

    public static void main(String[] args) {
        final ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("a","abstract");
        map.put("b","basic");
        Runnable r = () -> {
            for (Map.Entry<String,String> entry : map.entrySet()) {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {

                }
                System.out.println(entry.getKey() + " , " + entry.getValue());
            }
        };

        Thread t = new Thread(r);
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put("c","call");
        map.put("g","call");
    }
}