package com.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/23 18:37
 * @description
 */
public class FutureTest {
    static  List<Shop> shops = Arrays.asList(
            new Shop("shopA"),
            new Shop("shopB"),
            new Shop("shopC"),
            new Shop("shopD")
    );

    static  List<Shop> shops2 = Arrays.asList(
            new Shop("shopA"),
            new Shop("shopB"),
            new Shop("shopC"),
            new Shop("shopD"),
            new Shop("shopE")
    );

    private static final Executor executor =
            Executors.newFixedThreadPool(Math.min(shops2.size(), 100),
                    new ThreadFactory() {
                        public Thread newThread(Runnable r) {
                            Thread t = new Thread(r);
                            t.setDaemon(true);
                            return t;
                        }
                    });

    /**
     * 顺序执行
     * @param product
     * @return
     */
    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getShopName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 使用并行流执行
     * @param product
     * @return
     */
    public static List<String> findPricesByParaellStream(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getShopName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public static List<String> findPricesByParaellStream2(String product) {
        return shops2.parallelStream()
                .map(shop -> String.format("%s price is %.2f",
                        shop.getShopName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    /**
     * 异步执行
     * @param product
     * @return
     */
    public static List<String> findPricesAsync(String product) {
        List<CompletableFuture<String>> futures =
                shops.stream().map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getShopName() + " price is " + shop.getPrice(product)
                )).collect(Collectors.toList());
        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static List<String> findPricesAsync2(String product) {
        List<CompletableFuture<String>> futures =
                shops2.stream().map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getShopName() + " price is " + shop.getPrice(product)
                )).collect(Collectors.toList());
        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static List<String> findPricesAsync3(String product) {
        List<CompletableFuture<String>> futures =
                shops2.stream().map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getShopName() + " price is " + shop.getPrice(product), executor
                )).collect(Collectors.toList());
        return futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        //顺序
//        System.out.println(findPrices("galaxy S10"));
        //并行流-4t
//        System.out.println(findPricesByParaellStream("galaxy S10"));
        //并行流-5t
//        System.out.println(findPricesByParaellStream2("galaxy S10"));
        //异步执行-4t
//        System.out.println(findPricesAsync("galaxy S10"));
        //异步执行-5t
//        System.out.println(findPricesAsync2("galaxy S10"));
        //异步执行-dynamic
        System.out.println(findPricesAsync3("galaxy S10"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

}