package com.watermelon.limiter;

/**
 * <h1>TokenBucket</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/6
 */
public class TokenBucketLimiter {

    /**
     * 桶的容量
     */
    private final double capacity;

    /**
     * 生成令牌的速率
     */
    private final double refillRatePerSecond;

    /**
     * 上次生成令牌的时间戳
     */
    private long lastRefillTime;

    /**
     * 当前桶里的令牌数量
     */
    private double currentTokens;

    public TokenBucketLimiter(double capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.lastRefillTime = System.nanoTime();
        this.currentTokens = capacity;
    }

    public synchronized boolean tryAcquire(double tokens) {
        refillTokens();
        if (tokens <= currentTokens) {
            currentTokens -= tokens;
            return true;
        } else {
            return false;
        }
    }

    private void refillTokens() {
        long currentTime = System.nanoTime();
        double refillTokens = (currentTime - lastRefillTime) / 1000_000_000.0 * refillRatePerSecond;
        currentTokens = Math.min(capacity, currentTokens + refillTokens);
        lastRefillTime = currentTime;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketLimiter tokenBucketLimiter = new TokenBucketLimiter(10, 2);
        System.out.println(tokenBucketLimiter.tryAcquire(10));
        System.out.println(tokenBucketLimiter.tryAcquire(1));
        Thread.sleep(1000);
        System.out.println(tokenBucketLimiter.tryAcquire(2));
        System.out.println(tokenBucketLimiter.currentTokens);
        Thread.sleep(500);
        System.out.println(tokenBucketLimiter.tryAcquire(1));
    }

}