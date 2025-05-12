package com.watermelon.limiter;

/**
 * <h1>FixedWindowLimiter</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/6
 */
public class FixedWindowLimiter {

    /**
     * 窗口最大请求次数
     */
    private final long maxRequests;

    /**
     * 窗口大小
     */
    private final long windowMillis;

    /**
     * 窗口起始时间
     */
    private long windowStartTime;

    /**
     * 窗口当前次数
     */
    private long count;

    public FixedWindowLimiter(long maxRequests, long windowMillis) {
        this.maxRequests = maxRequests;
        this.windowMillis = windowMillis;
        this.windowStartTime = System.currentTimeMillis() / windowMillis * windowMillis;
        this.count = 0;
    }

    public boolean allowRequest(long tokens) {
        long currentTime = System.currentTimeMillis();
        long currentWindowStartTime = currentTime / windowMillis * windowMillis;
        if (currentWindowStartTime != windowStartTime) {
            windowStartTime = currentWindowStartTime;
            count = 0;
        }
        if (count + tokens <= maxRequests) {
            count += tokens;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FixedWindowLimiter fixedWindowLimiter = new FixedWindowLimiter(3, 1000);
        System.out.println(fixedWindowLimiter.allowRequest(3));
        System.out.println(fixedWindowLimiter.allowRequest(1));
        Thread.sleep(1000);
        System.out.println(fixedWindowLimiter.allowRequest(1));
    }
}