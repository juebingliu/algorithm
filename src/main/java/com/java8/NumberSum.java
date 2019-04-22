package com.java8;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/18 18:58
 * @description 求和 - (i5-4c-2.2gHz)
 */
public class NumberSum {

    public static void main(String[] args) {
        //串行
//        System.out.println("seq:"+NumberSum.test(NumberSum::sequentialSum,10_000_000) + "ms");

        //并行
//        System.out.println("paralle:" + NumberSum.test(NumberSum::parallelSum,10_000_000) + "ms");

        //传统迭代
//        System.out.println("iterator:" + NumberSum.test(NumberSum::iterativeSum, 10_000_000) + "ms");

        //串行优化
//        System.out.println("seq-opt:" + NumberSum.test(NumberSum::sequentialSum2,10_000_000) + "ms");

        //并行优化
//        System.out.println("paralle-opt:" + NumberSum.test(NumberSum::parallelSum2,10_000_000) + "ms");

        //共享状态
//        System.out.println("share:" + NumberSum.test(NumberSum::sideEffectSum,10_000_000) + "ms");

        //分支&合并
        System.out.println("fork&join:" +NumberSum.test(SumCalculator::sumParrell,10_000_000) + "ms");
    }

    //串行归纳
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    //并行归纳
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    //迭代归纳
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    //串行归纳-优化
    public static long sequentialSum2(long n) {
        return LongStream.rangeClosed(1,n)
                .reduce(0L,Long::sum);
    }

    //并行归纳-优化
    public static long parallelSum2(long n) {
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0L,Long::sum);
    }

    //执行10次累加，计算平均时间
    public static long test(Function<Long,Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("result:" + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
//        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
    public static class Accumulator {
        public long total = 0;
        public void add(long value) { total += value; }
    }

}