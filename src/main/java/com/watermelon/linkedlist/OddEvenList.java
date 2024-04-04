package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/4/4 16:58
 * @see : https://leetcode.cn/problems/odd-even-linked-list/description/
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static class ListNode {
        int value;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
