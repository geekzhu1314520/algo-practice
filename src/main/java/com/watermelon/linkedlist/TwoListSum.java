package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/4/4 11:52
 * @see : https://leetcode.cn/problems/add-two-numbers-ii/description/
 */
public class TwoListSum {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {

        // 链表反转
        ListNode pHead1 = reverseList(head1);
        ListNode pHead2 = reverseList(head2);

        ListNode curr1 = pHead1;
        ListNode curr2 = pHead2;

        ListNode pre3 = null;
        int nextValue = 0;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + nextValue;
            nextValue = sum / 10;

            ListNode newNode = new ListNode(sum % 10, pre3);
            pre3 = newNode;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int sum = curr1.val + nextValue;
            nextValue = sum / 10;

            ListNode newNode = new ListNode(sum % 10, pre3);
            pre3 = newNode;

            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int sum = curr2.val + nextValue;
            nextValue = sum / 10;

            ListNode newNode = new ListNode(sum % 10, pre3);
            pre3 = newNode;

            curr2 = curr2.next;
        }

        if (nextValue > 0) {
            ListNode newNode = new ListNode(nextValue, pre3);
            pre3 = newNode;
        }

        return pre3;

    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}