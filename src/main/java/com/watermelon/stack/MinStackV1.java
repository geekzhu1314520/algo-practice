package com.watermelon.stack;

import java.util.Stack;

/**
 * @author zhujiashuai
 * @date: 2024/5/1 10:00
 * @see :https://leetcode.cn/problems/min-stack/description/
 */
public class MinStackV1 {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStackV1() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.add(val);
        }
    }

    int pop() {
        Integer pop = stack.pop();
        if (!minStack.isEmpty() && minStack.peek().equals(pop)) {
            minStack.pop();
        }
        return pop;
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
