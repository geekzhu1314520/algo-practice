package com.watermelon.thread;

/**
 * <h1>AlternatePrint</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/7
 */
public class AlternatePrint {

    private static int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "奇数线程").start();

        new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }, "偶数线程").start();
    }

}