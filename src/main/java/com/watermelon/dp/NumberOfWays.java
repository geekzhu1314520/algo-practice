package com.watermelon.dp;

/**
 * <h1>NumberOfWays</h1>
 *
 * @author zhujiashuai
 * @since 2025/5/5
 */
public class NumberOfWays {


    /**
     * 计算从起点到终点恰好移动k步的不同方法数
     *
     * @param startPos 起始位置
     * @param endPos 目标位置
     * @param k 需要移动的步数
     * @return 不同方法数对10^9+7取模的结果
     */
    public int numberOfWays(int startPos, int endPos, int k) {
        // 取模数
        int mod = 1000000007;
        // 计算起点和终点的距离
        int diff = Math.abs(endPos - startPos);
        // 如果距离大于步数,或者剩余步数不能被2整除,则无法到达
        if (diff > k || (k - diff) % 2 != 0) {
            return 0;
        }

        // dp[i][j]表示走i步,与起点的距离为j的方案数
        // 由于可以走到负数位置，所以j的范围是[-k, k]
        long[][] dp = new long[k + 1][2 * k + 1];
        // 初始状态:不移动时距离为0的方案数为1
        dp[0][k] = 1; // k表示距离0的位置
        // 遍历步数
        for (int i = 1; i <= k; i++) {
            // 遍历当前可能的距离，范围是[-i, i]
            for (int j = k - i; j <= k + i; j++) {
                // 向右走一步
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                // 向左走一步
                if (j < 2 * k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        // 返回走k步到达目标距离的方案数
        // 需要将实际距离映射到dp数组下标
        return (int)dp[k][k + (endPos - startPos)];
    }

}