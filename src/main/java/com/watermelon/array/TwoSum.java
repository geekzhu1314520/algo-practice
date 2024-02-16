package com.watermelon.array;

import java.util.Arrays;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 14:11
 * @see : https://leetcode.cn/problems/two-sum/description/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int left = 0;
        int right = sortedNums.length - 1;

        int index = 0;
        int[] result = new int[2];

        while (left < right) {
            if (sortedNums[left] + sortedNums[right] == target) {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == sortedNums[left] || nums[i] == sortedNums[right]) {
                        result[index ++] = i;
                    }
                }
                break;
            } else if (sortedNums[left] + sortedNums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
