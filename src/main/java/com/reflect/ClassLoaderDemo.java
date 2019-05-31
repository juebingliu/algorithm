package com.reflect;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/5/31 14:59
 * @description
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        try {
            Class cls = cl.loadClass("java.util.ArrayList");
            ClassLoader actualLoader = cls.getClassLoader();
            System.out.println(actualLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}