package com.watermelon.dp;

/**
 * <h1>Rob</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class Rob {

    /**
     * 打家劫舍问题 - 计算可以偷窃到的最高金额
     * 相邻的房屋不能同时偷窃，求能偷窃到的最大金额
     *
     * @param nums 每个房屋存放金额的数组
     * @return 可以偷窃到的最高金额
     */
    public int rob(int[] nums) {
        // 处理边界情况:数组为空或长度为0时返回0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 只有一个房屋时直接返回其金额
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i]表示偷窃到第i个房屋时可以获得的最大金额
        int[] dp = new int[nums.length];
        // 初始化第一个房屋的金额
        dp[0] = nums[0];
        // 初始化第二个房屋的最大金额(取第一个和第二个中的较大值)
        dp[1] = Math.max(nums[0], nums[1]);

        // 动态规划计算每个位置的最大金额
        for (int i = 2; i < nums.length; i++) {
            // 状态转移方程：当前房屋要么不偷(dp[i-1])，要么偷了并且加上dp[i-2]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        // 返回最后一个房屋处能够偷窃到的最大金额
        return dp[nums.length - 1];
    }

}