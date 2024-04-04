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
 * @date: 2024/4/4 18:47
 * @description:
 */
public class DeleteDuplicateIITest extends UnitTestBase {

    @Test
    public void testDeleteDuplicates_case1() {

        DeleteDuplicateII.ListNode node5 = new DeleteDuplicateII.ListNode(3, null);
        DeleteDuplicateII.ListNode node4 = new DeleteDuplicateII.ListNode(2, node5);
        DeleteDuplicateII.ListNode node3 = new DeleteDuplicateII.ListNode(1, node4);
        DeleteDuplicateII.ListNode node2 = new DeleteDuplicateII.ListNode(1, node3);
        DeleteDuplicateII.ListNode node1 = new DeleteDuplicateII.ListNode(1, node2);

        DeleteDuplicateII deleteDuplicateII = new DeleteDuplicateII();
        DeleteDuplicateII.ListNode node = deleteDuplicateII.deleteDuplicates(node1);

        List<Integer> allValues = new ArrayList<>();
        while (node != null) {
            allValues.add(node.val);
            node = node.next;
        }
        assertThat(allValues, Is.is(Arrays.asList(2, 3)));
    }

}
