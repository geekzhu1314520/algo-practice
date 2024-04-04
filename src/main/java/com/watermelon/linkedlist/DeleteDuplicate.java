package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/4/4 17:41
 * @see : https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 */
public class DeleteDuplicate {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.value == pre.value) {
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicatesV2(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode curr = head;

        while (curr.next != null) {
            if (curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
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


