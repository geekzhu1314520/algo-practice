package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 16:19
 * @description:
 */
public class PlusOneTest extends UnitTestBase {

    @Test
    public void plusOne_case1() {
        PlusOne plusOne = new PlusOne();
        int[] nums = plusOne.plusOne(new int[] {1, 2, 3});
        assertThat(nums, Is.is(new int[] {1, 2, 4}));
    }

    @Test
    public void plusOne_case2() {
        PlusOne plusOne = new PlusOne();
        int[] nums = plusOne.plusOne(new int[] {4, 3, 2, 1});
        assertThat(nums, Is.is(new int[] {4, 3, 2, 2}));
    }

    @Test
    public void plusOne_case3() {
        PlusOne plusOne = new PlusOne();
        int[] nums = plusOne.plusOne(new int[] {9, 9, 9, 9});
        assertThat(nums, Is.is(new int[] {1, 0, 0, 0, 0}));
    }

    @Test
    public void plusOne_case4() {
        PlusOne plusOne = new PlusOne();
        int[] nums = plusOne.plusOne(new int[] {0});
        assertThat(nums, Is.is(new int[] {1}));
    }

}
