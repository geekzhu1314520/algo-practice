package com.watermelon.stack;

/**
 * @author zhujiashuai
 * @date: 2024/5/1 10:00
 * @see :https://leetcode.cn/problems/min-stack/description/
 */
public class MinStackV4 {

    Node head;

    void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            Node newNode = new Node(val, Math.min(val, head.min));
            newNode.next = head;
            head = newNode;
        }
    }

    void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    int top() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    int getMin() {
        if (head == null) {
            return -1;
        }
        return head.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

}
