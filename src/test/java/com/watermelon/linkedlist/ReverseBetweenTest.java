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
public class ReverseBetweenTest extends UnitTestBase {

    @Test
    public void reverseBetween_case1() {

        ReverseBetween.ListNode node5 = new ReverseBetween.ListNode(5);
        ReverseBetween.ListNode node4 = new ReverseBetween.ListNode(4, node5);
        ReverseBetween.ListNode node3 = new ReverseBetween.ListNode(3, node4);
        ReverseBetween.ListNode node2 = new ReverseBetween.ListNode(2, node3);
        ReverseBetween.ListNode node1 = new ReverseBetween.ListNode(1, node2);

        ReverseBetween reverseBetween = new ReverseBetween();

        ReverseBetween.ListNode head = reverseBetween.reverseBetween(node1, 2, 4);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 4, 3, 2, 5)));
    }

    @Test
    public void reverseBetween_case2() {

        ReverseBetween.ListNode node5 = new ReverseBetween.ListNode(5);

        ReverseBetween reverseBetween = new ReverseBetween();

        ReverseBetween.ListNode head = reverseBetween.reverseBetween(node5, 1, 1);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(5)));
    }

    @Test
    public void reverseBetween_case3() {

        ReverseBetween.ListNode node2 = new ReverseBetween.ListNode(5);
        ReverseBetween.ListNode node1 = new ReverseBetween.ListNode(3, node2);

        ReverseBetween reverseBetween = new ReverseBetween();

        ReverseBetween.ListNode head = reverseBetween.reverseBetween(node1, 1, 1);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(3, 5)));
    }

}
