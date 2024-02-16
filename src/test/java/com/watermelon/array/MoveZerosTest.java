package com.watermelon.array;

import com.watermelon.UnitTestBase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhujiashuai
 * @date: 2024/2/11 22:53
 * @description:
 */
public class MoveZerosTest extends UnitTestBase {

    @Test
    public void moveZeros() {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeros(nums);
        Assert.assertArrayEquals(new int[] {1, 3, 12, 0, 0}, nums);
    }

    @Test
    public void moveZeros_array0() {
        int[] nums = new int[] {0};
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeros(nums);
        Assert.assertArrayEquals(new int[] {0}, nums);
    }

}
