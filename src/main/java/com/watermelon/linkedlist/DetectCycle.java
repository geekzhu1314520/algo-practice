package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/17 20:43
 * @see : https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
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
