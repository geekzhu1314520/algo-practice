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
 * @date: 2024/4/4 17:07
 * @description:
 */
public class OddEvenListTest extends UnitTestBase {

    @Test
    public void testOddEvenList_case1() {

        OddEvenList.ListNode node5 = new OddEvenList.ListNode(5, null);
        OddEvenList.ListNode node4 = new OddEvenList.ListNode(4, node5);
        OddEvenList.ListNode node3 = new OddEvenList.ListNode(3, node4);
        OddEvenList.ListNode node2 = new OddEvenList.ListNode(2, node3);
        OddEvenList.ListNode node1 = new OddEvenList.ListNode(1, node2);

        OddEvenList oddEvenList = new OddEvenList();
        OddEvenList.ListNode node = oddEvenList.oddEvenList(node1);

        List<Integer> allValues = new ArrayList<>();
        while (node != null) {
            allValues.add(node.value);
            node = node.next;
        }
        assertThat(allValues, Is.is(Arrays.asList(1, 3, 5, 2, 4)));
    }

    @Test
    public void testOddEvenList_case2() {

        OddEvenList.ListNode node4 = new OddEvenList.ListNode(4, null);
        OddEvenList.ListNode node3 = new OddEvenList.ListNode(3, node4);
        OddEvenList.ListNode node2 = new OddEvenList.ListNode(2, node3);
        OddEvenList.ListNode node1 = new OddEvenList.ListNode(1, node2);

        OddEvenList oddEvenList = new OddEvenList();
        OddEvenList.ListNode node = oddEvenList.oddEvenList(node1);

        List<Integer> allValues = new ArrayList<>();
        while (node != null) {
            allValues.add(node.value);
            node = node.next;
        }
        assertThat(allValues, Is.is(Arrays.asList(1, 3, 2, 4)));
    }

}
