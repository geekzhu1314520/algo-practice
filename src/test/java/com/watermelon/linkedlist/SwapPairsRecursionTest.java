package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * @author zhujiashuai
 * @date: 2024/2/17 11:35
 * @description:
 */
public class SwapPairsRecursionTest extends UnitTestBase {

    @Test
    public void swapPairs_case1() {

        SwapPairs.ListNode node4 = new SwapPairs.ListNode(4, null);
        SwapPairs.ListNode node3 = new SwapPairs.ListNode(3, node4);
        SwapPairs.ListNode node2 = new SwapPairs.ListNode(2, node3);
        SwapPairs.ListNode node1 = new SwapPairs.ListNode(1, node2);

        SwapPairsRecursion swapPairs = new SwapPairsRecursion();
        SwapPairs.ListNode head = swapPairs.swapPairs(node1);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(2, 1, 4, 3)));
    }

    @Test
    public void swapPairs_case2() {

        SwapPairs.ListNode node1 = new SwapPairs.ListNode(1, null);

        SwapPairsRecursion swapPairs = new SwapPairsRecursion();
        SwapPairs.ListNode head = swapPairs.swapPairs(node1);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1)));
    }

    @Test
    public void swapPairs_case3() {

        SwapPairs.ListNode node1 = null;

        SwapPairsRecursion swapPairs = new SwapPairsRecursion();
        SwapPairs.ListNode head = swapPairs.swapPairs(node1);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertNull(head);
    }

}
