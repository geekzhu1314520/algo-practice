package com.watermelon.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h1>AlterPrintLock</h1>
 *
 * @author zhujiashuai
 * @since 2025/4/7
 */
public class AlterPrintLock {

    private static int count = 1;

    private static final ReentrantLock lock = new ReentrantLock();

    /**
     * 奇数条件
     */
    private static final Condition oddCondition = lock.newCondition();

    /**
     * 偶数条件
     */
    private static final Condition evenCondition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                try {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        evenCondition.signal();
                    } else {
                        oddCondition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "奇数线程").start();

        new Thread(() -> {
            while (count <= 100) {
                lock.lock();
                try {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                        oddCondition.signal();
                    } else {
                        evenCondition.await();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }, "偶数线程").start();
    }

}