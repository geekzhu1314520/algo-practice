package com.watermelon.dp;

/**
 * <h1>CoinChange</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class CoinChange {

    /**
     * 计算凑成目标金额所需的最少硬币数量
     * 使用动态规划解决找零钱问题
     *
     * @param coins  可用的硬币面值数组
     * @param amount 目标金额
     * @return 所需的最少硬币数量，如果无法凑出则返回-1
     */
    public int coinChange(int[] coins, int amount) {
        // 如果目标金额为0，不需要硬币
        if (amount == 0) {
            return 0;
        }

        // dp[i]表示凑成金额i所需的最少硬币数
        int[] dp = new int[amount + 1];
        // 初始化dp数组，设置一个不可能达到的最大值
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        // 金额为0时不需要硬币
        dp[0] = 0;

        // 计算每个金额所需的最少硬币数
        for (int i = 1; i <= amount; i++) {
            // 尝试每个硬币面值
            for (int coin : coins) {
                // 当前硬币面值小于等于当前计算的金额时
                if (coin <= i) {
                    // 更新dp[i]，取当前值和使用当前硬币后所需硬币数+1的最小值
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果dp[amount]大于amount，说明无法凑出目标金额
        return dp[amount] > amount ? -1 : dp[amount];
    }

}