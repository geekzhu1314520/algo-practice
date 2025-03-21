package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/18 20:35
 * @description:
 */
public class FindKthLargest1Test extends UnitTestBase {

    @Test
    public void reverseKGroup_case1() {

        Solution.ListNode node4 = new Solution.ListNode(-4);
        Solution.ListNode node3 = new Solution.ListNode(0, node4);
        Solution.ListNode node2 = new Solution.ListNode(2, node3);
        Solution.ListNode node1 = new Solution.ListNode(3, node2);

        Solution solution = new Solution();
        Solution.ListNode node = solution.FindKthToTail(node1, 1);
        assertThat(-4, Is.is(node.val));
    }

    @Test
    public void reverseKGroup_case2() {
        Solution.ListNode node4 = new Solution.ListNode(-4);
        Solution.ListNode node3 = new Solution.ListNode(0, node4);
        Solution.ListNode node2 = new Solution.ListNode(2, node3);
        Solution.ListNode node1 = new Solution.ListNode(3, node2);

        Solution solution = new Solution();
        Solution.ListNode node = solution.FindKthToTail(node1, 4);
        assertThat(3, Is.is(node.val));
    }

}
