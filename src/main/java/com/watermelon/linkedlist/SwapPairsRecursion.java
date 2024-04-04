package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/17 15:02
 * @see : https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class SwapPairsRecursion {

    public SwapPairs.ListNode swapPairs(SwapPairs.ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        SwapPairs.ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }

}
