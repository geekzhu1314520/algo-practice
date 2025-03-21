package com.watermelon.stack;

import java.util.Stack;

/**
 * @author zhujiashuai
 * @date: 2024/5/1 10:00
 * @see :https://leetcode.cn/problems/min-stack/description/
 */
public class MinStackV3 {

    private Stack<Long> stack;
    private Long min;

    public MinStackV3() {
        stack = new Stack<>();
    }

    void push(long val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push(val - min);
        } else {
            stack.push(val - min);
            if (val < min) {
                min = val;
            }
        }
    }

    void pop() {
        long pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    long top() {
        long peek = stack.peek();
        if (peek < 0) {
            return min;
        } else {
            return min + peek;
        }
    }

    long getMin() {
        return min;
    }
}
