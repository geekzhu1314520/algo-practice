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
 * @date: 2024/2/17 22:28
 * @description:
 */
public class MergeTwoListsTest extends UnitTestBase {

    @Test
    public void mergeTwoLists_case1() {

        MergeTwoLists.ListNode node3 = new MergeTwoLists.ListNode(4);
        MergeTwoLists.ListNode node2 = new MergeTwoLists.ListNode(2, node3);
        MergeTwoLists.ListNode node1 = new MergeTwoLists.ListNode(1, node2);

        MergeTwoLists.ListNode node33 = new MergeTwoLists.ListNode(4);
        MergeTwoLists.ListNode node22 = new MergeTwoLists.ListNode(3, node33);
        MergeTwoLists.ListNode node11 = new MergeTwoLists.ListNode(1, node22);

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        MergeTwoLists.ListNode head = mergeTwoLists.mergeTwoLists(node1, node11);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 1, 2, 3, 4, 4)));
    }

    @Test
    public void mergeTwoLists_case2() {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        MergeTwoLists.ListNode head = mergeTwoLists.mergeTwoLists(null, null);
        assertNull(head);
    }

    @Test
    public void mergeTwoLists_case3() {

        MergeTwoLists.ListNode node1 = null;

        MergeTwoLists.ListNode node11 = new MergeTwoLists.ListNode(1, null);

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        MergeTwoLists.ListNode head = mergeTwoLists.mergeTwoLists(node1, node11);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1)));
    }

    @Test
    public void mergeTwoLists_case4() {

        MergeTwoLists.ListNode node3 = new MergeTwoLists.ListNode(7);
        MergeTwoLists.ListNode node2 = new MergeTwoLists.ListNode(6, node3);
        MergeTwoLists.ListNode node1 = new MergeTwoLists.ListNode(5, node2);

        MergeTwoLists.ListNode node33 = new MergeTwoLists.ListNode(4);
        MergeTwoLists.ListNode node22 = new MergeTwoLists.ListNode(3, node33);
        MergeTwoLists.ListNode node11 = new MergeTwoLists.ListNode(1, node22);

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        MergeTwoLists.ListNode head = mergeTwoLists.mergeTwoLists(node1, node11);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 3, 4, 5, 6, 7)));
    }

}
