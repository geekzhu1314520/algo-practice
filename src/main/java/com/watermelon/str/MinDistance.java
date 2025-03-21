package com.watermelon.str;

/**
 * <h1>MinDistance</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/10
 */
public class MinDistance {

    /**
     * 计算两个字符串之间的编辑距离(最少操作次数)
     * 可以对字符串进行的操作包括:插入、删除、替换
     * 使用动态规划求解,dp[i][j]表示word1的前i个字符转换到word2的前j个字符需要的最少操作数
     *
     * @param word1 源字符串
     * @param word2 目标字符串
     * @return 最少操作次数
     */
    public int minDistance(String word1, String word2) {
        // 获取两个字符串的长度
        int m = word1.length();
        int n = word2.length();
        // 创建dp数组,dp[i][j]表示word1前i个字符转换到word2前j个字符需要的最少操作数
        int[][] dp = new int[m + 1][n + 1];

        // 初始化边界条件:空串转换到另一个字符串的操作数
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // 动态规划计算最少操作数
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前字符相同时,不需要额外操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前字符不同时,取替换、删除、插入三种操作的最小值
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

}