package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 10:17
 * @description:
 */
public class ClimbStairsTest extends UnitTestBase {

    @Test
    public void testBoundary_lessThan1() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("入参不正确");
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStairsV2(0);
    }

    @Test
    public void testBoundary_moreThan45() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("入参不正确");
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStairsV2(46);
    }

    @Test
    public void testClimbStairs_45() {
        ClimbStairs climbStairs = new ClimbStairs();
        assertThat(climbStairs.climbStairsV2(45), Is.is(1836311903));
    }

}
