package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * @author zhujiashuai
 * @date: 2024/2/25 20:42
 * @description:
 */
public class FindFirstCommonNodeTest extends UnitTestBase {

    @Test
    public void findFirstCommonNode_case1() {

        FindFirstCommonNode.ListNode node7 = new FindFirstCommonNode.ListNode(7);
        FindFirstCommonNode.ListNode node6 = new FindFirstCommonNode.ListNode(6, node7);

        FindFirstCommonNode.ListNode node5 = new FindFirstCommonNode.ListNode(5, node6);
        FindFirstCommonNode.ListNode node4 = new FindFirstCommonNode.ListNode(4, node5);

        FindFirstCommonNode.ListNode node3 = new FindFirstCommonNode.ListNode(3, node6);
        FindFirstCommonNode.ListNode node2 = new FindFirstCommonNode.ListNode(2, node3);
        FindFirstCommonNode.ListNode node1 = new FindFirstCommonNode.ListNode(1, node2);

        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        FindFirstCommonNode.ListNode node = findFirstCommonNode.findFirstCommonNode(node1, node4);

        assertThat(node, Is.is(node6));
    }

    @Test
    public void findFirstCommonNode_case2() {

        FindFirstCommonNode.ListNode node8 = new FindFirstCommonNode.ListNode(8);
        FindFirstCommonNode.ListNode node7 = new FindFirstCommonNode.ListNode(7);
        FindFirstCommonNode.ListNode node6 = new FindFirstCommonNode.ListNode(6, node7);

        FindFirstCommonNode.ListNode node5 = new FindFirstCommonNode.ListNode(5, node8);
        FindFirstCommonNode.ListNode node4 = new FindFirstCommonNode.ListNode(4, node5);

        FindFirstCommonNode.ListNode node3 = new FindFirstCommonNode.ListNode(3, node6);
        FindFirstCommonNode.ListNode node2 = new FindFirstCommonNode.ListNode(2, node3);
        FindFirstCommonNode.ListNode node1 = new FindFirstCommonNode.ListNode(1, node2);

        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();
        FindFirstCommonNode.ListNode node = findFirstCommonNode.findFirstCommonNode(node1, node4);

        assertNull(node);
    }

}
