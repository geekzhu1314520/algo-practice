package com.watermelon.array;

/**
 * @see "https://leetcode.cn/problems/maximum-subarray/"
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 当前位置的最大子数组和等于当前元素值与"当前元素值+前面位置的最大子数组和"中的较大值
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新全局最大和
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

}