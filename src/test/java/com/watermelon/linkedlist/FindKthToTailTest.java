package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * @author zhujiashuai
 * @date: 2024/2/25 15:08
 * @description:
 */
public class FindKthToTailTest extends UnitTestBase {

    @Test
    public void findKthToTail_case1() {

        FindKthToTail.ListNode node4 = new FindKthToTail.ListNode(-4);
        FindKthToTail.ListNode node3 = new FindKthToTail.ListNode(0, node4);
        FindKthToTail.ListNode node2 = new FindKthToTail.ListNode(2, node3);
        FindKthToTail.ListNode node1 = new FindKthToTail.ListNode(3, node2);

        FindKthToTail findKthToTail = new FindKthToTail();
        FindKthToTail.ListNode node = findKthToTail.findKthToTail(node1, 1);
        assertThat(-4, Is.is(node.val));
    }

    @Test
    public void findKthToTail_case2() {
        FindKthToTail.ListNode node4 = new FindKthToTail.ListNode(-4);
        FindKthToTail.ListNode node3 = new FindKthToTail.ListNode(0, node4);
        FindKthToTail.ListNode node2 = new FindKthToTail.ListNode(2, node3);
        FindKthToTail.ListNode node1 = new FindKthToTail.ListNode(3, node2);

        FindKthToTail findKthToTail = new FindKthToTail();
        FindKthToTail.ListNode node = findKthToTail.findKthToTail(node1, 4);
        assertThat(3, Is.is(node.val));
    }

    @Test
    public void findKthToTail_case3() {
        FindKthToTail.ListNode node4 = new FindKthToTail.ListNode(-4);
        FindKthToTail.ListNode node3 = new FindKthToTail.ListNode(0, node4);
        FindKthToTail.ListNode node2 = new FindKthToTail.ListNode(2, node3);
        FindKthToTail.ListNode node1 = new FindKthToTail.ListNode(3, node2);

        FindKthToTail findKthToTail = new FindKthToTail();
        FindKthToTail.ListNode node = findKthToTail.findKthToTail(node1, 5);
        assertNull(node);
    }


}
