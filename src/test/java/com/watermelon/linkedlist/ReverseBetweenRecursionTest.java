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
 * @date: 2024/2/18 15:36
 * @description:
 */
public class ReverseBetweenRecursionTest extends UnitTestBase {

    @Test
    public void reverseBetween_case1() {

        ReverseBetweenRecursion.ListNode node5 = new ReverseBetweenRecursion.ListNode(5);
        ReverseBetweenRecursion.ListNode node4 = new ReverseBetweenRecursion.ListNode(4, node5);
        ReverseBetweenRecursion.ListNode node3 = new ReverseBetweenRecursion.ListNode(3, node4);
        ReverseBetweenRecursion.ListNode node2 = new ReverseBetweenRecursion.ListNode(2, node3);
        ReverseBetweenRecursion.ListNode node1 = new ReverseBetweenRecursion.ListNode(1, node2);

        ReverseBetweenRecursion reverseBetween = new ReverseBetweenRecursion();

        ReverseBetweenRecursion.ListNode head = reverseBetween.reverseBetween(node1, 2, 4);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 4, 3, 2, 5)));
    }

    @Test
    public void reverseBetween_case2() {

        ReverseBetweenRecursion.ListNode node5 = new ReverseBetweenRecursion.ListNode(5);

        ReverseBetweenRecursion reverseBetween = new ReverseBetweenRecursion();

        ReverseBetweenRecursion.ListNode head = reverseBetween.reverseBetween(node5, 1, 1);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(5)));
    }

    @Test
    public void reverseBetween_case3() {

        ReverseBetweenRecursion.ListNode node2 = new ReverseBetweenRecursion.ListNode(5);
        ReverseBetweenRecursion.ListNode node1 = new ReverseBetweenRecursion.ListNode(3, node2);

        ReverseBetweenRecursion reverseBetween = new ReverseBetweenRecursion();

        ReverseBetweenRecursion.ListNode head = reverseBetween.reverseBetween(node1, 1, 1);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(3, 5)));
    }

}
