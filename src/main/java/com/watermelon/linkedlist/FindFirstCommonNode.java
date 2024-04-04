package com.watermelon.linkedlist;

/**
 * @author zhujiashuai
 * @date: 2024/2/25 20:36
 * @description:
 */
public class FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode curr1 = pHead1;
        ListNode curr2 = pHead2;

        while (curr1 !=  curr2) {
            curr1 = curr1 == null ? pHead2 : curr1.next;
            curr2 = curr2 == null ? pHead1 : curr2.next;
        }
        return curr1;
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
