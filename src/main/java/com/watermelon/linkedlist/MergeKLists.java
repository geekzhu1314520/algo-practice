package com.watermelon.linkedlist;

import java.util.ArrayList;

/**
 * @author zhujiashuai
 * @date: 2024/2/20 14:50
 * @description:
 */
public class MergeKLists {

    public ListNode mergeKListsV1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode minNode = new ListNode(Integer.MAX_VALUE);
        int minIndex = -1;

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            if (temp != null && temp.val < minNode.val) {
                minNode = temp;
                minIndex = i;
            }
        }

        if (minIndex == -1) {
            return null;
        }

        lists[minIndex] = minNode.next;
        minNode.next = mergeKListsV1(lists);
        return minNode;
    }

    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        if (l > r) {
            return null;
        }

        int middle = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, middle), merge(lists, middle + 1, r));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
