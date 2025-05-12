package com.watermelon.thread;

/**
 * <h1>DeadLockDemo</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/7
 */
public class DeadLockDemo {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                }
            }
        }).start();
    }

}