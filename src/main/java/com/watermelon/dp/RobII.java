package com.watermelon.dp;

/**
 * <h1>RobII</h1>
 *
 * @author zhujiashuai
 * @since 2025/5/8
 */
public class RobII {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 分两种情况:
        // 1. 偷第一家,不偷最后一家
        // 2. 不偷第一家,偷最后一家
        return Math.max(
            robRange(nums, 0, nums.length - 2),
            robRange(nums, 1, nums.length - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }

        return second;

    }

}