package com.watermelon.dp;

/**
 * <h1>MaxProfit</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class MaxProfit {

    /**
     * 计算股票交易的最大利润 - 含冷冻期
     * 冷冻期规则:卖出股票后第二天无法买入
     *
     * @param prices 每天的股票价格数组
     * @return 能获得的最大利润
     */
    public int maxProfit(int[] prices) {
        // 边界条件判断:空数组或只有一个价格时无法交易,返回0
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        // dp[i][0]: 持有股票的最大收益
        // dp[i][1]: 不持有股票,且处于冷冻期的最大收益
        // dp[i][2]: 不持有股票,且不处于冷冻期的最大收益
        int[][] dp = new int[n][3];

        // 初始化第一天的状态
        dp[0][0] = -prices[0];  // 第一天买入股票
        dp[0][1] = 0;           // 第一天不可能处于冷冻期
        dp[0][2] = 0;           // 第一天不持有股票且非冷冻期

        for (int i = 1; i < n; i++) {
            // 持有股票:前一天持有股票或从非冷冻期买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            // 不持有股票且处于冷冻期:前一天卖出
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 不持有股票且不处于冷冻期:前一天是冷冻期或非冷冻期
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        // 最后一天不持有股票的最大值(冷冻期或非冷冻期)
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

}