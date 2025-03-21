package com.watermelon.dp;

/**
 * <h1>MaxCoins</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class MaxCoins {

    /**
     * 计算戳破气球能获得的最大硬币数
     * 思路:动态规划,从小区间到大区间依次计算最优解
     * 1. 在原数组首尾添加1,方便计算边界情况
     * 2. dp[i][j]表示戳破(i,j)开区间内所有气球能得到的最大硬币数
     * 3. 对于每个区间,枚举最后戳破的气球k,取最大值
     *
     * @param nums 气球数组,nums[i]表示第i个气球中的硬币数
     * @return 能获得的最大硬币数
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 处理空数组情况
        if (n == 0) {
            return 0;
        }

        // 创建一个新数组,在首尾添加1,方便处理边界情况
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }

        // dp[i][j]表示戳破(i,j)开区间内的所有气球能得到的最大硬币数
        int[][] dp = new int[n + 2][n + 2];

        // len表示开区间长度,从小区间到大区间依次计算
        for (int len = 1; len <= n; len++) {
            // i表示开区间左端点
            for (int i = 1; i <= n - len + 1; i++) {
                // j表示开区间右端点
                int j = i + len - 1;
                // k为最后一个被戳破的气球,枚举k计算最大值
                for (int k = i; k <= j; k++) {
                    // 状态转移方程:dp[i][j] = max(dp[i][j], dp[i][k-1] + nums[i-1]*nums[k]*nums[j+1] + dp[k+1][j])
                    dp[i][j] = Math.max(dp[i][j],
                        dp[i][k - 1] + temp[i - 1] * temp[k] * temp[j + 1] + dp[k + 1][j]);
                }
            }
        }

        // 返回整个区间[1,n]的最优解
        return dp[1][n];
    }

}