package com.watermelon.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhujiashuai
 * @date: 2024/4/6 12:19
 * @description:
 */
public class HelloQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        // [1, 2, 3, 4]
        System.out.println(queue);
        // 1
        System.out.println(queue.poll());
        // [2, 3, 4]
        System.out.println(queue);
        // 2
        System.out.println(queue.peek());
        // [2, 3, 4]
        System.out.println(queue);
        // 2
        // 3
        // 4
        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }

    }
}
