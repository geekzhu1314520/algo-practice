package com.watermelon.linkedlist;

/**
 * <h1>IntersectionNode</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/10
 */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        // 当pA和pB相等时，要么是交点，要么是null
        while (pA != pB) {
            // 如果pA到达链表尾部，则将其重定向到headB
            // 否则移动到下一个节点
            pA = (pA == null) ? headB : pA.next;

            // 如果pB到达链表尾部，则将其重定向到headA
            // 否则移动到下一个节点
            pB = (pB == null) ? headA : pB.next;
        }

        return pA; // 返回交点，如果没有交点则为null


    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}