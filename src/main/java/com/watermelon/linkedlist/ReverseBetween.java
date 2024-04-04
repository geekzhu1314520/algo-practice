package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/18 15:34
 * @see : https://leetcode.cn/problems/reverse-linked-list-ii/description/
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here

        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode lpre = new ListNode(-1);
        int mcount = 1;
        while (left != null) {
            if (mcount == m) {
                break;
            }
            lpre = left;
            left = left.next;
            mcount++;
        }

        ListNode right = left;
        int ncount = 1;
        while (right != null) {
            if (ncount == n - m + 1) {
                break;
            }
            right = right.next;
            ncount++;
        }
        ListNode next = right.next;

        int k = n - m + 1;
        ListNode mnHead = reverseListK(left, k);

        lpre.next = mnHead;
        left.next = next;

        return m == 1 ? mnHead : head;
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
