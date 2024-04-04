package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/25 14:59
 * @description:
 */
public class FindKthToTail {

    public ListNode findKthToTail(ListNode pHead, int k) {

        ListNode slow = pHead;
        ListNode fast = pHead;

        int index = 1;
        while (index <= k && fast != null) {
            fast = fast.next;
            index++;
        }

        if (fast == null && index <= k) {
            return null;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

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
