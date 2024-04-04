package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/18 15:34
 * @see : https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class ReverseBetweenRecursion {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here

        if (head == null || head.next == null) {
            return head;
        }

        if (m == 1) {
            ListNode nIndex = head;
            for (int i = 1; i < n; i++) {
                nIndex = nIndex.next;
            }
            ListNode next = nIndex.next;
            ListNode newHead = reverseListK(head, n - m + 1);
            head.next = next;
            return newHead;
        }
        ListNode node = reverseBetween(head.next, m - 1, n - 1);
        head.next = node;
        return head;
    }

    private ListNode reverseListK(ListNode head, int k) {

        ListNode pre = null;
        ListNode curr = head;

        int count = 1;
        while (curr != null && count <= k) {
            count++;
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
