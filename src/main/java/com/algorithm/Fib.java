package com.algorithm;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/2/20 14:20
 * @description 斐波那契数列的实现方式
 */
public class Fib {

    public static int fib(int size) {
        if(size <= 2) {
            return 1;
        }else {
            //循环调用本函数
            return fib(size - 2) + fib(size - 1);
        }
    }

    public static int fib2(int size) {
        int sum = 0;
        int a = 1;
        int b = 1;
        for(int i = 1; i <= size; i++){
            if(i <= 2) {
                sum =  1;
            } else {
                sum = a + b;
                a = b;
                b = sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //建立一个for循环，用于打印第一个至第十个数字
        for(int i = 1;i <= 10;i++) {
            //调用函数进行打印
            System.out.print(fib2(i) + "\t");
        }
    }
}