package com.watermelon.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhujiashuai
 * @date: 2024/4/7 22:08
 * @see : https://leetcode.cn/problems/min-stack/description/
 */
public class MinStack {

    private Stack<Integer> stack;
    private LinkedList<Integer> minList;

    public MinStack() {
        stack = new Stack<>();
        minList = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);

        Iterator<Integer> iterator = minList.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (val <= next) {
                break;
            }
            index++;
        }
        minList.add(index, val);
    }

    public int pop() {
        int pop = stack.pop();
        Iterator<Integer> iterator = minList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (pop == next) {
                iterator.remove();
                break;
            }
        }
        return pop;
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.getFirst();
    }
}
