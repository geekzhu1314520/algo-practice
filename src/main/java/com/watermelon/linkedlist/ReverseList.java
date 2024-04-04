package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 21:08
 * @see : https://leetcode.cn/problems/reverse-linked-list/description/
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {

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

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
