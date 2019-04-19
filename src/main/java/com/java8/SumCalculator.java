package com.java8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/19 14:34
 * @description fork&join 并行sum
 */
public class SumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start;
    private final int end;

    //子任务不可fork时的阈值
    public static final long THRESHOLD = 10_000;

    public SumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public SumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= THRESHOLD) {
            return sumSequent();
        }
        SumCalculator left = new SumCalculator(numbers,start,start+length/2);
        left.fork();
        SumCalculator right = new SumCalculator(numbers,start + length/2,end);
        Long rightRes = right.compute();
        Long leftRes = left.join();
        return leftRes + rightRes;
    }

    //当子任务不能够继续fork时，调用迭代累加
    private long sumSequent() {
        long sum = 0;
        for (int i = start; i<end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    //并行计算
    public static long sumParrell(long n) {
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinTask<Long> task = new SumCalculator(numbers);
        //启动
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {

    }
}