package com.watermelon.stack;

import java.util.Stack;

/**
 * @author zhujiashuai
 * @date: 2024/5/1 10:00
 * @see :https://leetcode.cn/problems/min-stack/description/
 */
public class MinStackV2 {

    private Stack<Integer> stack;
    private Integer min;

    public MinStackV2() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    void push(int val) {
        if (min >= val) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    int pop() {
        Integer pop = stack.pop();
        if (pop.equals(min)) {
            min = stack.pop();
        }
        return pop;
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return min;
    }
}
