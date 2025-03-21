package com.watermelon.dp;

/**
 * <h1>NumSquares</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class NumSquares {

    /**
     * 计算和为n的完全平方数的最少数量
     * 例如: n=12, 可以表示为 4+4+4=12, 返回3
     * 动态规划解法:
     * dp[i]表示和为i的完全平方数的最少数量
     * 状态转移方程: dp[i] = min(dp[i], dp[i-j*j] + 1), j从1到sqrt(i)
     *
     * @param n 目标数字
     * @return 完全平方数的最少数量
     */
    public int numSquares(int n) {
        // 创建dp数组,dp[i]表示和为i的完全平方数的最少数量
        int[] dp = new int[n + 1];
        // 初始化dp[0]=0
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // 最坏情况下,i可以由i个1组成
            dp[i] = i;
            // 尝试用j*j来组成i
            for (int j = 1; j * j <= i; j++) {
                // dp[i-j*j] + 1表示使用一个j*j和组成i-j*j的最少数量
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}