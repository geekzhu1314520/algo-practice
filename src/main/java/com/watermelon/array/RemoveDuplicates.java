package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 19:48
 * @see : https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        int i = 0, index = 1, n = nums.length;
        while (index < n) {
            if (nums[index] != nums[i]) {
                nums[++i] = nums[index];
            }
            index++;
        }
        return i + 1;
    }

}
