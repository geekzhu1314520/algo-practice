package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/4/4 12:27
 * @description:
 */
public class TwoListSumTest extends UnitTestBase {

    @Test
    public void testAddTwoNumbers_case1() {

        TwoListSum.ListNode node1 = new TwoListSum.ListNode(7, null);
        TwoListSum.ListNode node2 = new TwoListSum.ListNode(3, node1);
        TwoListSum.ListNode node3 = new TwoListSum.ListNode(9, node2);

        TwoListSum.ListNode node4 = new TwoListSum.ListNode(3, null);
        TwoListSum.ListNode node5 = new TwoListSum.ListNode(6, node4);

        TwoListSum twoListSum = new TwoListSum();
        TwoListSum.ListNode head = twoListSum.addTwoNumbers(node3, node5);

        List<Integer> allValueList = new ArrayList<>();
        while (head != null) {
            allValueList.add(head.val);
            head = head.next;
        }
        assertThat(allValueList, Is.is(Arrays.asList(1, 0, 0, 0)));
    }

    @Test
    public void testAddTwoNumbers_case2() {

        TwoListSum.ListNode node1 = new TwoListSum.ListNode(7, null);
        TwoListSum.ListNode node2 = new TwoListSum.ListNode(3, node1);
        TwoListSum.ListNode node3 = new TwoListSum.ListNode(9, node2);

        TwoListSum.ListNode node5 = null;

        TwoListSum twoListSum = new TwoListSum();
        TwoListSum.ListNode head = twoListSum.addTwoNumbers(node3, node5);

        List<Integer> allValueList = new ArrayList<>();
        while (head != null) {
            allValueList.add(head.val);
            head = head.next;
        }
        assertThat(allValueList, Is.is(Arrays.asList(9, 3, 7)));
    }

    @Test
    public void testAddTwoNumbers_case3() {

        TwoListSum.ListNode node3 = null;

        TwoListSum.ListNode node4 = new TwoListSum.ListNode(3, null);
        TwoListSum.ListNode node5 = new TwoListSum.ListNode(6, node4);

        TwoListSum twoListSum = new TwoListSum();
        TwoListSum.ListNode head = twoListSum.addTwoNumbers(node3, node5);

        List<Integer> allValueList = new ArrayList<>();
        while (head != null) {
            allValueList.add(head.val);
            head = head.next;
        }
        assertThat(allValueList, Is.is(Arrays.asList(6, 3)));
    }

}
