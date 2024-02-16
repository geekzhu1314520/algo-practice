package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 14:17
 * @description:
 */
public class TwoSum2Test extends UnitTestBase {

    @Test
    public void twoSum_case1() {
        TwoSum2 twoSum = new TwoSum2();
        int[] nums = new int[] {2, 7, 11, 15};
        int[] indexArray = twoSum.twoSum(nums, 9);
        assertThat(indexArray, Is.is(new int[] {0, 1}));
    }

    @Test
    public void twoSum_case2() {
        TwoSum2 twoSum = new TwoSum2();
        int[] nums = new int[] {3, 2, 4};
        int[] indexArray = twoSum.twoSum(nums, 6);
        assertThat(indexArray, Is.is(new int[] {1, 2}));
    }

    @Test
    public void twoSum_case3() {
        TwoSum2 twoSum = new TwoSum2();
        int[] nums = new int[] {3, 3};
        int[] indexArray = twoSum.twoSum(nums, 6);
        assertThat(indexArray, Is.is(new int[] {0, 1}));
    }

}
