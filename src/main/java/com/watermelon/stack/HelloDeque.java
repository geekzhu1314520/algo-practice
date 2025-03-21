package com.watermelon.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhujiashuai
 * @date: 2024/4/6 13:22
 * @description:
 */
public class HelloDeque {

    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        // [c, b, a]
        System.out.println(deque);
        // c
        System.out.println(deque.peek());
        // [c, b, a]
        System.out.println(deque);
        // c
        // b
        // a
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
    }

}
