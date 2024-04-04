package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author zhujiashuai
 * @date: 2024/2/17 19:46
 * @description:
 */
public class HasCycleTest extends UnitTestBase {

    @Test
    public void hasCycle_case1() {

        HasCycle.ListNode node4 = new HasCycle.ListNode(4);
        HasCycle.ListNode node3 = new HasCycle.ListNode(0, node4);
        HasCycle.ListNode node2 = new HasCycle.ListNode(2, node3);
        HasCycle.ListNode node1 = new HasCycle.ListNode(3, node2);
        node4.next = node2;

        HasCycle hasCycle = new HasCycle();
        assertTrue(hasCycle.hasCycle(node1));
    }

    @Test
    public void hasCycle_case2() {

        HasCycle.ListNode node2 = new HasCycle.ListNode(2);
        HasCycle.ListNode node1 = new HasCycle.ListNode(3, node2);
        node2.next = node1;

        HasCycle hasCycle = new HasCycle();
        assertTrue(hasCycle.hasCycle(node1));
    }

    @Test
    public void hasCycle_case3() {

        HasCycle.ListNode node1 = new HasCycle.ListNode(3);

        HasCycle hasCycle = new HasCycle();
        assertFalse(hasCycle.hasCycle(node1));
    }

}
