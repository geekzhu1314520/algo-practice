package com.watermelon.limiter;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * <h1>OptimizeSlidingWindowLimiter</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/6
 */
public class OptimizeSlidingWindowLimiter {

    private final long maxRequests;
    private final long windowMillis;

    private final ConcurrentSkipListMap<Long, Integer> slices;

    private final long sliceMillis;

    public OptimizeSlidingWindowLimiter(long maxRequests, long windowMillis) {
        this(maxRequests, windowMillis, windowMillis / 10);
    }

    public OptimizeSlidingWindowLimiter(long maxRequests, long windowMillis, long sliceMillis) {
        this.maxRequests = maxRequests;
        this.windowMillis = windowMillis;
        this.slices = new ConcurrentSkipListMap<>();
        this.sliceMillis = sliceMillis;
    }

    public synchronized boolean allowRequest(int weight) {
        // 当前时间片
        long now = System.currentTimeMillis();
        long currentSlice = now / sliceMillis * sliceMillis;

        // 移除过期的时间片
        slices.headMap(now - windowMillis).clear();

        // 计算已有的请求总次数
        int total = slices.values().stream().mapToInt(v -> v).sum();

        // 是否可请求判定
        if (total + weight <= maxRequests) {
            slices.merge(currentSlice, weight, Integer::sum);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OptimizeSlidingWindowLimiter slidingWindowLimiter = new OptimizeSlidingWindowLimiter(3, 1000);
        System.out.println(slidingWindowLimiter.allowRequest(3));
        System.out.println(slidingWindowLimiter.allowRequest(1));
        Thread.sleep(1000);
        System.out.println(slidingWindowLimiter.allowRequest(1));
        System.out.println(slidingWindowLimiter.allowRequest(2));
        System.out.println(slidingWindowLimiter.allowRequest(1));
    }
}