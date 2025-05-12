package com.watermelon.limiter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>SlidingWindowLimiter</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/6
 */
public class SlidingWindowLimiter {

    private final long maxRequest;

    private final long windowMillis;

    private final Queue<Long> timeQueue;

    public SlidingWindowLimiter(long maxRequest, long windowMillis) {
        this.maxRequest = maxRequest;
        this.windowMillis = windowMillis;
        this.timeQueue = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        evictExpired(now);
        if (timeQueue.size() < maxRequest) {
            timeQueue.offer(now);
            return true;
        } else {
            return false;
        }
    }

    public synchronized boolean allowRequest(int weight) {
        long now = System.currentTimeMillis();
        evictExpired(now);
        if (timeQueue.size() + weight <= maxRequest) {
            for(int i=0; i<weight; i++) {
                timeQueue.offer(now);
            }
            return true;
        } else {
            return false;
        }
    }

    private void evictExpired(long now) {
        while (!timeQueue.isEmpty() && now - timeQueue.peek() > windowMillis) {
            timeQueue.poll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowLimiter slidingWindowLimiter = new SlidingWindowLimiter(3, 1000);
        System.out.println(slidingWindowLimiter.allowRequest(3));
        System.out.println(slidingWindowLimiter.allowRequest(1));
        Thread.sleep(1000);
        System.out.println(slidingWindowLimiter.allowRequest(1));
        System.out.println(slidingWindowLimiter.allowRequest(2));
        System.out.println(slidingWindowLimiter.allowRequest(1));
    }

}