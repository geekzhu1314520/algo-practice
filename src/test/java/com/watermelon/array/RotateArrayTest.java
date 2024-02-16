package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/13 10:09
 * @description:
 */
public class RotateArrayTest extends UnitTestBase {

    @Test
    public void rotate() {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, k);

        assertThat(nums, Is.is(new int[] {5, 6, 7, 1, 2, 3, 4}));
    }

}
