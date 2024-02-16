package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 19:49
 * @description:
 */
public class RemoveDuplicatesTest extends UnitTestBase {

    @Test
    public void testRemoveDuplicates_case1() {

        int[] nums = new int[] {1, 1, 2};
        int[] expectNums = new int[] {1, 2};

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int length = removeDuplicates.removeDuplicates(nums);

        assertThat(length, Is.is(2));
        for (int i = 0; i < length; i++) {
            assertThat(nums[i], Is.is(expectNums[i]));
        }
    }

    @Test
    public void testRemoveDuplicates_case2() {

        int[] nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectNums = new int[] {0, 1, 2, 3, 4};

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int length = removeDuplicates.removeDuplicates(nums);

        assertThat(length, Is.is(5));
        for (int i = 0; i < length; i++) {
            assertThat(nums[i], Is.is(expectNums[i]));
        }
    }

}
