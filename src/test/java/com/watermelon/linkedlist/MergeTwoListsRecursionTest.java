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
 * @date: 2024/2/17 23:26
 * @description:
 */
public class MergeTwoListsRecursionTest extends UnitTestBase {

    @Test
    public void mergeTwoListsRecursion_case1() {

        MergeTwoListsRecursion.ListNode node3 = new MergeTwoListsRecursion.ListNode(4);
        MergeTwoListsRecursion.ListNode node2 = new MergeTwoListsRecursion.ListNode(2, node3);
        MergeTwoListsRecursion.ListNode node1 = new MergeTwoListsRecursion.ListNode(1, node2);

        MergeTwoListsRecursion.ListNode node33 = new MergeTwoListsRecursion.ListNode(4);
        MergeTwoListsRecursion.ListNode node22 = new MergeTwoListsRecursion.ListNode(3, node33);
        MergeTwoListsRecursion.ListNode node11 = new MergeTwoListsRecursion.ListNode(1, node22);

        MergeTwoListsRecursion mergeTwoListsRecursion = new MergeTwoListsRecursion();
        MergeTwoListsRecursion.ListNode head = mergeTwoListsRecursion.mergeTwoLists(node1, node11);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 1, 2, 3, 4, 4)));
    }

    @Test
    public void mergeTwoListsRecursion_case2() {
        MergeTwoListsRecursion mergeTwoListsRecursion = new MergeTwoListsRecursion();
        MergeTwoListsRecursion.ListNode head = mergeTwoListsRecursion.mergeTwoLists(null, null);
        assertNull(head);
    }

    @Test
    public void mergeTwoListsRecursion_case3() {

        MergeTwoListsRecursion.ListNode node1 = null;

        MergeTwoListsRecursion.ListNode node11 = new MergeTwoListsRecursion.ListNode(1, null);

        MergeTwoListsRecursion mergeTwoListsRecursion = new MergeTwoListsRecursion();
        MergeTwoListsRecursion.ListNode head = mergeTwoListsRecursion.mergeTwoLists(node1, node11);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1)));
    }

    @Test
    public void mergeTwoListsRecursion_case4() {

        MergeTwoListsRecursion.ListNode node3 = new MergeTwoListsRecursion.ListNode(7);
        MergeTwoListsRecursion.ListNode node2 = new MergeTwoListsRecursion.ListNode(6, node3);
        MergeTwoListsRecursion.ListNode node1 = new MergeTwoListsRecursion.ListNode(5, node2);

        MergeTwoListsRecursion.ListNode node33 = new MergeTwoListsRecursion.ListNode(4);
        MergeTwoListsRecursion.ListNode node22 = new MergeTwoListsRecursion.ListNode(3, node33);
        MergeTwoListsRecursion.ListNode node11 = new MergeTwoListsRecursion.ListNode(1, node22);

        MergeTwoListsRecursion mergeTwoListsRecursion = new MergeTwoListsRecursion();
        MergeTwoListsRecursion.ListNode head = mergeTwoListsRecursion.mergeTwoLists(node1, node11);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 3, 4, 5, 6, 7)));
    }

}
