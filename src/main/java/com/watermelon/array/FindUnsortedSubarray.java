package com.watermelon.array;

/**
 * <h1>FindUnsortedSubarray</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int max = nums[0];
        int min = nums[n-1];
        int end = -1;
        int start = 0;

        // 从左到右找最后一个逆序位置
        for (int i = 1; i < n; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
        }

        // 从右到左找第一个逆序位置
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] > min) {
                start = i;
            } else {
                min = nums[i];
            }
        }

        return end == -1 ? 0 : end - start + 1;
    }
}