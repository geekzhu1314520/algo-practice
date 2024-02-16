package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/13 10:09
 * @see : https://leetcode.cn/problems/rotate-array/description/
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return;
        }

        if (k < 1) {
            return;
        }

        int rotateK = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, rotateK - 1);
        reverse(nums, rotateK, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
