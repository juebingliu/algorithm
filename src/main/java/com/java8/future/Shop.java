package com.java8.future;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/4/23 18:29
 * @description
 */
public class Shop {

    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 延迟1s执行,模拟耗时操作,顺序执行
     * @param product
     * @return
     */
    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return product.charAt(0) + product.charAt(1) + random.nextDouble()*10;
    }

    /**
     * 异步执行
     * @param product
     * @return
     */
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
            double price = calculatePrice(product);
            futurePrice.complete(price);
        }).start();
        return futurePrice;
    }
}