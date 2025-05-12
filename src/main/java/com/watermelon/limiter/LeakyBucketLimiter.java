package com.watermelon.limiter;

/**
 * <h1>LeakyBucket</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/6
 */
public class LeakyBucketLimiter {
    /**
     * 桶的容量
     */
    private final double capacity;

    /**
     * 出水率
     */
    private final double leakyRatePerSec;

    /**
     * 当前水量
     */
    private double currentWater;

    /**
     * 上次更新时间
     */
    private long lastLeakyTime;

    public LeakyBucketLimiter(double capacity, double leakyRatePerSec) {
        this.capacity = capacity;
        this.leakyRatePerSec = leakyRatePerSec;
        this.currentWater = 0;
        this.lastLeakyTime = System.nanoTime();
    }

    /**
     * 判断流量是否可通过
     *
     * @param tokens 流量
     * @return true:可通过，不触发限流；false：不可通过，触发限流
     */
    public synchronized boolean leakyBucketTryAcquire(int tokens) {
        long currentTime = System.nanoTime();
        double outerWater = (currentTime - lastLeakyTime) / 1000_000_000.0 * leakyRatePerSec;
        currentWater = Math.max(0, currentWater - outerWater);
        lastLeakyTime = currentTime;
        if (currentWater + tokens <= capacity) {
            currentWater += tokens;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LeakyBucketLimiter leakyBucketLimiter = new LeakyBucketLimiter(3, 1);
        System.out.println(leakyBucketLimiter.leakyBucketTryAcquire(3));
        System.out.println(leakyBucketLimiter.leakyBucketTryAcquire(1));
        Thread.sleep(1000);
        System.out.println(leakyBucketLimiter.leakyBucketTryAcquire(1));
    }

}