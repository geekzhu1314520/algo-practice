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
 * @date: 2024/2/20 21:09
 * @description:
 */
public class MergeKListsWithArrayListTest extends UnitTestBase {

    @Test
    public void mergeKListsV1_case1() {

        MergeKLists.ListNode node3 = new MergeKLists.ListNode(3);
        MergeKLists.ListNode node2 = new MergeKLists.ListNode(2, node3);
        MergeKLists.ListNode node1 = new MergeKLists.ListNode(1, node2);

        MergeKLists.ListNode node7 = new MergeKLists.ListNode(7);
        MergeKLists.ListNode node6 = new MergeKLists.ListNode(6, node7);
        MergeKLists.ListNode node5 = new MergeKLists.ListNode(5, node6);
        MergeKLists.ListNode node4 = new MergeKLists.ListNode(4, node5);

        ArrayList<MergeKLists.ListNode> lists = new ArrayList<MergeKLists.ListNode>() {{
            add(node1);
            add(node4);
        }};

        MergeKListsWithArrayList mergeKLists = new MergeKListsWithArrayList();
        MergeKLists.ListNode head = mergeKLists.mergeKListsV1(lists);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    public void mergeKListsV1_case2() {

        MergeKLists.ListNode node2 = new MergeKLists.ListNode(2);
        MergeKLists.ListNode node1 = new MergeKLists.ListNode(1, node2);

        MergeKLists.ListNode node5 = new MergeKLists.ListNode(5);
        MergeKLists.ListNode node4 = new MergeKLists.ListNode(4, node5);
        MergeKLists.ListNode node3 = new MergeKLists.ListNode(1, node4);

        MergeKLists.ListNode node6 = new MergeKLists.ListNode(6);

        ArrayList<MergeKLists.ListNode> lists = new ArrayList<MergeKLists.ListNode>() {{
            add(node1);
            add(node3);
            add(node6);
        }};

        MergeKListsWithArrayList mergeKLists = new MergeKListsWithArrayList();
        MergeKLists.ListNode head = mergeKLists.mergeKListsV1(lists);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 1, 2, 4, 5, 6)));
    }

    @Test
    public void mergeKListsV2_case1() {

        MergeKLists.ListNode node3 = new MergeKLists.ListNode(3);
        MergeKLists.ListNode node2 = new MergeKLists.ListNode(2, node3);
        MergeKLists.ListNode node1 = new MergeKLists.ListNode(1, node2);

        MergeKLists.ListNode node7 = new MergeKLists.ListNode(7);
        MergeKLists.ListNode node6 = new MergeKLists.ListNode(6, node7);
        MergeKLists.ListNode node5 = new MergeKLists.ListNode(5, node6);
        MergeKLists.ListNode node4 = new MergeKLists.ListNode(4, node5);

        ArrayList<MergeKLists.ListNode> lists = new ArrayList<MergeKLists.ListNode>() {{
            add(node1);
            add(node4);
        }};

        MergeKListsWithArrayList mergeKLists = new MergeKListsWithArrayList();
        MergeKLists.ListNode head = mergeKLists.mergeKListsV2(lists);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    public void mergeKListsV2_case2() {

        MergeKLists.ListNode node2 = new MergeKLists.ListNode(2);
        MergeKLists.ListNode node1 = new MergeKLists.ListNode(1, node2);

        MergeKLists.ListNode node5 = new MergeKLists.ListNode(5);
        MergeKLists.ListNode node4 = new MergeKLists.ListNode(4, node5);
        MergeKLists.ListNode node3 = new MergeKLists.ListNode(1, node4);

        MergeKLists.ListNode node6 = new MergeKLists.ListNode(6);

        ArrayList<MergeKLists.ListNode> lists = new ArrayList<MergeKLists.ListNode>() {{
            add(node1);
            add(node3);
            add(node6);
        }};

        MergeKListsWithArrayList mergeKLists = new MergeKListsWithArrayList();
        MergeKLists.ListNode head = mergeKLists.mergeKListsV2(lists);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(1, 1, 2, 4, 5, 6)));
    }

}
