package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/18 00:13
 * @see : https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
            if (count == k) {
                break;
            }
        }

        // 不足K个，直接返回
        if (count < k) {
            return head;
        }
        // 翻转前K个元素
        ListNode newHead = reversListK(head, k);
        // 递归翻转后续元素
        head.next = reverseKGroup(curr, k);
        return newHead;
    }

    private ListNode reversListK(ListNode head, int k) {

        ListNode pre = null;
        ListNode curr = head;

        int index = 0;
        while (curr != null && ++index <= k) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
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

