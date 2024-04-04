package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/4/4 15:56
 * @see : https://leetcode.cn/problems/palindrome-linked-list/submissions/520068994/
 */
public class PalindromeList {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = reverseList(slow);
        ListNode left = head;

        while (left != null && middle != null) {
            if (left.val != middle.val) {
                return false;
            }
            left = left.next;
            middle = middle.next;
        }

        return middle == null;
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
