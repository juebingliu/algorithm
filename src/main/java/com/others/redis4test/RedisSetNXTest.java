package com.others.redis4test;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author juebing
 * @version v1.0
 * @date 2019/6/25 18:04
 * @description redis分布式锁实现
 */
public class RedisSetNXTest extends Thread{

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";

    private String auctionCode;

    public RedisSetNXTest(String auctionCode) {
        super(auctionCode);
        this.auctionCode = auctionCode;
    }

    private static int bidPrice = 100;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始");

        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("goodsprice","0");
        System.out.println("输入初始化值:"+jedis.get("goodsprice"));
        jedis.close();
        RedisSetNXTest thread1 = new RedisSetNXTest("A001");
        RedisSetNXTest thread2  = new RedisSetNXTest("B001");
        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程运行开始 ");
        Jedis jedis = new Jedis("127.0.0.1",6379);
        try {
            if(Thread.currentThread().getName()=="B001"){
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //先让A拿到锁
        boolean isOk = tryGetDistributedLock(jedis, "goods_lock", Thread.currentThread().getName(), 10000L);

        try {
            if(Thread.currentThread().getName()=="A001"){
                sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(isOk) {
            System.out.println("子线程"+ this.auctionCode + "拿到锁");
            String v= jedis.get("goodsprice");
            Integer iv = Integer.valueOf(v);
            if (bidPrice > iv) {
                Integer bp = iv + 100;
                //事务未提交
                jedis.set("goodsprice",String.valueOf(bp));
                System.out.println("子线程"+this.auctionCode +", 出价："+ jedis.get("goodsprice") +"，出价时间："+System.nanoTime());
            }else{
                System.out.println("出价低于现有价格！");
            }

            boolean isOk1=  releaseDistributedLock(jedis, "goods_lock", Thread.currentThread().getName());
            if(isOk1){
                System.out.println("子线程"+this.auctionCode +"释放锁");
            }
        }else{

            System.out.println("子线程" + auctionCode + "未拿到锁");
        }
        jedis.close();
        System.out.println(Thread.currentThread().getName() + "线程运行结束");
    }

    /**
     * 尝试获取分布式锁
     * @param jedis
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    public boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, long expireTime) {

        String result = null;
        try {
            result = jedis.set(lockKey,"1","NX", "EX",expireTime);
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     * @param jedis
     * @param lockKey
     * @param requestId
     * @return
     */
    public boolean releaseDistributedLock(Jedis jedis,String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1] == ARGV[1]) then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}