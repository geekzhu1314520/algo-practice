package com.watermelon.linkedlist;

import java.util.ArrayList;

/**
 * @author zhujiashuai
 * @date: 2024/2/20 21:06
 * @description:
 */
public class MergeKListsWithArrayList {

    public MergeKLists.ListNode mergeKListsV1(ArrayList<MergeKLists.ListNode> lists) {

        if (lists == null || lists.size() == 0) {
            return null;
        }

        MergeKLists.ListNode minNode = new MergeKLists.ListNode(Integer.MAX_VALUE);
        int minIndex = -1;

        for (int i = 0; i < lists.size(); i++) {
            MergeKLists.ListNode temp = lists.get(i);
            if (temp != null && temp.val < minNode.val) {
                minNode = temp;
                minIndex = i;
            }
        }

        if (minIndex == -1) {
            return null;
        }

        lists.remove(minIndex);
        lists.add(minNode.next);

        minNode.next = mergeKListsV1(lists);
        return minNode;
    }

    public MergeKLists.ListNode mergeKListsV2(ArrayList<MergeKLists.ListNode> lists) {

        if (lists == null || lists.size() == 0) {
            return null;
        }

        return merge(lists, 0, lists.size() - 1);
    }

    private MergeKLists.ListNode merge(ArrayList<MergeKLists.ListNode> lists, int l, int r) {

        if (l > r) {
            return null;
        }

        if (l == r) {
            return lists.get(l);
        }

        int middle = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, middle), merge(lists, middle + 1, r));
    }

    private MergeKLists.ListNode mergeTwoLists(MergeKLists.ListNode l1, MergeKLists.ListNode l2) {

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

}
