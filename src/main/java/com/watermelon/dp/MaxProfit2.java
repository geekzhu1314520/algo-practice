package com.watermelon.dp;

/**
 * <h1>MaxProfit</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class MaxProfit2 {

    /**
     * 计算股票交易的最大利润 - 含冷冻期
     * 冷冻期规则:卖出股票后第二天无法买入
     *
     * @param prices 每天的股票价格数组
     * @return 能获得的最大利润
     */
    public int maxProfit(int[] prices) {
        // 如果价格数组为空或只有一天,无法交易,返回0
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        // dp[i][0]:第i天持有股票的最大利润
        // dp[i][1]:第i天不持有股票,且不在冷冻期的最大利润
        // dp[i][2]:第i天不持有股票,处于冷冻期的最大利润
        int[][] dp = new int[n][3];

        // 初始化第0天的状态
        dp[0][0] = -prices[0];  // 买入股票
        dp[0][1] = 0;           // 不操作
        dp[0][2] = 0;           // 不操作

        for (int i = 1; i < prices.length; i++) {
            // 第i天持有股票 = max(第i-1天持有股票, 第i-1天冷冻期结束后买入)
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            // 第i天不持有股票且不在冷冻期 = max(第i-1天持有股票今天卖出, 第i-1天不持有股票且不在冷冻期)
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
            // 第i天处于冷冻期 = 第i-1天卖出股票的状态
            dp[i][2] = dp[i - 1][1];
        }

        // 返回最后一天不持有股票的最大利润
        return dp[n - 1][1];
    }
}