package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/11 22:52
 * @see : https://leetcode.cn/problems/move-zeroes/description/
 */
public class MoveZeros {

    public void moveZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
