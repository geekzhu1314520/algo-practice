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
 * @date: 2024/2/18 01:17
 * @description:
 */
public class ReverseKGroupTest extends UnitTestBase {

    @Test
    public void reverseKGroup_case1() {

        ReverseKGroup.ListNode node5 = new ReverseKGroup.ListNode(5);
        ReverseKGroup.ListNode node4 = new ReverseKGroup.ListNode(4, node5);
        ReverseKGroup.ListNode node3 = new ReverseKGroup.ListNode(3, node4);
        ReverseKGroup.ListNode node2 = new ReverseKGroup.ListNode(2, node3);
        ReverseKGroup.ListNode node1 = new ReverseKGroup.ListNode(1, node2);

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ReverseKGroup.ListNode head = reverseKGroup.reverseKGroup(node1, 2);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.value);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(2, 1, 4, 3, 5)));
    }

    @Test
    public void reverseKGroup_case2() {

        ReverseKGroup.ListNode node5 = new ReverseKGroup.ListNode(5);
        ReverseKGroup.ListNode node4 = new ReverseKGroup.ListNode(4, node5);
        ReverseKGroup.ListNode node3 = new ReverseKGroup.ListNode(3, node4);
        ReverseKGroup.ListNode node2 = new ReverseKGroup.ListNode(2, node3);
        ReverseKGroup.ListNode node1 = new ReverseKGroup.ListNode(1, node2);

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ReverseKGroup.ListNode head = reverseKGroup.reverseKGroup(node1, 3);

        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.value);
            head = head.next;
        }
        assertThat(nums, Is.is(Arrays.asList(3, 2, 1, 4, 5)));
    }

}
