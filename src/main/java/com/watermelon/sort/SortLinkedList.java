package com.watermelon.sort;

/**
 * <h1>SortLinkedList</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/10
 */
public class SortLinkedList {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 分割链表
        ListNode mid = slow.next;
        slow.next = null;

        // 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // 合并两个有序链表
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = left != null ? left : right;

        return dummy.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}