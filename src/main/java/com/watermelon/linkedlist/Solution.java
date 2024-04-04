package com.watermelon.linkedlist;

public class Solution {

    public ListNode FindKthToTail(ListNode pHead, int k) {

        int length = 0;
        ListNode pIndex = pHead;
        while (pIndex != null) {
            length ++;
            pIndex = pIndex.next;
        }

        if(k > length) {
            return null;
        }

        int n = length - k;

        ListNode curr = pHead;
        while (--n >= 0 && curr != null) {
            curr = curr.next;
        }
        return curr;
    }

    public ListNode FindKthToTailV2(ListNode pHead, int k) {

        int length = 0;
        ListNode pIndex = pHead;
        while (pIndex != null) {
            length ++;
            pIndex = pIndex.next;
        }

        if(k > length) {
            return null;
        }

        int n = length - k;

        ListNode curr = pHead;
        while (--n >= 0 && curr != null) {
            curr = curr.next;
        }
        return curr;
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