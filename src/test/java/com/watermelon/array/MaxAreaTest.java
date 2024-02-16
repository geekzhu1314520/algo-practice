package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 08:42
 * @description:
 */
public class MaxAreaTest extends UnitTestBase {

    @Test
    public void maxArea_testBoundary() {
        int[] height = new int[] {1, 1};
        MaxArea maxArea = new MaxArea();
        Assert.assertThat(maxArea.maxArea(height), Is.is(1));
    }

    @Test
    public void maxArea_testNormal() {
        int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea maxArea = new MaxArea();
        Assert.assertThat(maxArea.maxArea(height), Is.is(49));
    }

}
