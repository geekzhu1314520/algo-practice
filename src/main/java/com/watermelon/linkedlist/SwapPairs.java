package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/17 11:32
 * @see : https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1, head);
        ListNode curr = head;

        ListNode ret = head.next;

        while (curr != null) {
            ListNode next = curr.next;
            if(next == null) {
                break;
            }
            curr.next = next.next;
            next.next = curr;
            pre.next = next;
            pre = curr;
            curr = curr.next;
        }
        return ret;
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
