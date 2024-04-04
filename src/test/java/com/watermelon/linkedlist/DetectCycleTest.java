package com.watermelon.linkedlist;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * @author zhujiashuai
 * @date: 2024/2/17 19:46
 * @description:
 */
public class DetectCycleTest extends UnitTestBase {

    @Test
    public void detectCycle_case1() {

        DetectCycle.ListNode node4 = new DetectCycle.ListNode(4);
        DetectCycle.ListNode node3 = new DetectCycle.ListNode(0, node4);
        DetectCycle.ListNode node2 = new DetectCycle.ListNode(2, node3);
        DetectCycle.ListNode node1 = new DetectCycle.ListNode(3, node2);
        node4.next = node2;

        DetectCycle detectCycle = new DetectCycle();
        assertThat(detectCycle.detectCycle(node1), Is.is(node2));
    }

    @Test
    public void detectCycle_case2() {

        DetectCycle.ListNode node2 = new DetectCycle.ListNode(2);
        DetectCycle.ListNode node1 = new DetectCycle.ListNode(3, node2);
        node2.next = node1;

        DetectCycle detectCycle = new DetectCycle();
        assertThat(detectCycle.detectCycle(node1), Is.is(node1));
    }

    @Test
    public void detectCycle_case3() {

        DetectCycle.ListNode node1 = new DetectCycle.ListNode(3);

        DetectCycle detectCycle = new DetectCycle();
        assertNull(detectCycle.detectCycle(node1));
    }

}
