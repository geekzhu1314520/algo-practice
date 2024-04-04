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
 * @date: 2024/4/4 17:55
 * @description:
 */
public class DeleteDuplicateTest extends UnitTestBase {

    @Test
    public void testDeleteDuplicate_case1() {

        DeleteDuplicate.ListNode node3 = new DeleteDuplicate.ListNode(2, null);
        DeleteDuplicate.ListNode node2 = new DeleteDuplicate.ListNode(1, node3);
        DeleteDuplicate.ListNode node1 = new DeleteDuplicate.ListNode(1, node2);

        DeleteDuplicate deleteDuplicate = new DeleteDuplicate();
        DeleteDuplicate.ListNode node = deleteDuplicate.deleteDuplicatesV2(node1);

        List<Integer> allValues = new ArrayList<>();
        while (node != null) {
            allValues.add(node.value);
            node = node.next;
        }
        assertThat(allValues, Is.is(Arrays.asList(1, 2)));
    }

    @Test
    public void testDeleteDuplicate_case2() {

        DeleteDuplicate.ListNode node5 = new DeleteDuplicate.ListNode(3, null);
        DeleteDuplicate.ListNode node4 = new DeleteDuplicate.ListNode(3, node5);
        DeleteDuplicate.ListNode node3 = new DeleteDuplicate.ListNode(2, node4);
        DeleteDuplicate.ListNode node2 = new DeleteDuplicate.ListNode(1, node3);
        DeleteDuplicate.ListNode node1 = new DeleteDuplicate.ListNode(1, node2);

        DeleteDuplicate deleteDuplicate = new DeleteDuplicate();
        DeleteDuplicate.ListNode node = deleteDuplicate.deleteDuplicatesV2(node1);

        List<Integer> allValues = new ArrayList<>();
        while (node != null) {
            allValues.add(node.value);
            node = node.next;
        }
        assertThat(allValues, Is.is(Arrays.asList(1, 2, 3)));
    }

}
