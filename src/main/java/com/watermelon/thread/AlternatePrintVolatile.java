package com.watermelon.thread;

/**
 * <h1>AlternatePrintVolitile</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/7
 */
public class AlternatePrintVolatile {

    private static volatile int count = 1;
    private static volatile boolean isOdd = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count <= 100) {
                if (isOdd && count % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    isOdd = false;
                }
            }
        }, "奇数线程").start();

        new Thread(() -> {
            while (count <= 100) {
                if (!isOdd && count % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    isOdd = true;
                }
            }
        }, "偶数线程").start();
    }
}