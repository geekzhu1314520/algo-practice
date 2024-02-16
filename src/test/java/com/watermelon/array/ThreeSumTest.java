package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 17:20
 * @description:
 */
public class ThreeSumTest extends UnitTestBase {

    @Test
    public void threeSum_whenNumIsEmpty() {
        ThreeSum threeSum = new ThreeSum();
        assertThat(threeSum.threeSum(new int[] {}).size(), Is.is(0));
    }

    @Test
    public void threeSum_whenNumIsAllZero() {
        ThreeSum threeSum = new ThreeSum();
        assertThat(threeSum.threeSum(new int[] {0,0,0}).size(), Is.is(1));
    }

    @Test
    public void threeSum_whenNumNotMatch() {
        ThreeSum threeSum = new ThreeSum();
        assertThat(threeSum.threeSum(new int[] {0,1,1}).size(), Is.is(0));
    }

    @Test
    public void threeSum_whenNumMatch() {
        ThreeSum threeSum = new ThreeSum();
        assertThat(threeSum.threeSum(new int[] {-1,0,1,2,-1,-4}).size(), Is.is(2));
    }
}
