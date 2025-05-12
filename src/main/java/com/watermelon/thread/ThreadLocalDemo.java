package com.watermelon.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h1>ThreadLocalDemo</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/7
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    int count = counter.get();
                    count++;
                    counter.set(count);
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                } finally {
                    counter.remove();
                }
            });
        }
        executorService.shutdown();
    }

}