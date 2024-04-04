package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 21:10
 * @see : https://leetcode.cn/problems/reverse-linked-list/description/
 */
public class ReverseListTest extends UnitTestBase {

    @Test
    public void reverseList_case1() {

        ReverseList.ListNode node5 = new ReverseList.ListNode(5);
        ReverseList.ListNode node4 = new ReverseList.ListNode(4, node5);
        ReverseList.ListNode node3 = new ReverseList.ListNode(3, node4);
        ReverseList.ListNode node2 = new ReverseList.ListNode(2, node3);
        ReverseList.ListNode node1 = new ReverseList.ListNode(1, node2);

        ReverseList reverseList = new ReverseList();
        ReverseList.ListNode cur = reverseList.reverseList(node1);
        List<Integer> nodeValueList = new ArrayList<>();
        while (cur != null) {
            nodeValueList.add(cur.val);
            cur = cur.next;
        }
        assertThat(nodeValueList, Is.is(Arrays.asList(5, 4, 3, 2, 1)));
    }

    @Test
    public void reverseList_case2() {

        ReverseList.ListNode node2 = new ReverseList.ListNode(2, null);
        ReverseList.ListNode node1 = new ReverseList.ListNode(1, node2);

        ReverseList reverseList = new ReverseList();
        ReverseList.ListNode cur = reverseList.reverseList(node1);
        List<Integer> nodeValueList = new ArrayList<>();
        while (cur != null) {
            nodeValueList.add(cur.val);
            cur = cur.next;
        }
        assertThat(nodeValueList, Is.is(Arrays.asList(2, 1)));
    }

    @Test
    public void reverseList_case3() {

        ReverseList.ListNode node1 = null;

        ReverseList reverseList = new ReverseList();
        ReverseList.ListNode head = reverseList.reverseList(node1);

        Assert.assertNull(head);
    }

    @Test
    public void reverseList_case4() {

        ReverseList.ListNode node1 = new ReverseList.ListNode(1, null);

        ReverseList reverseList = new ReverseList();
        ReverseList.ListNode head = reverseList.reverseList(node1);

        assertThat(head.val, Is.is(1));
        Assert.assertNull(head.next);
    }

}
