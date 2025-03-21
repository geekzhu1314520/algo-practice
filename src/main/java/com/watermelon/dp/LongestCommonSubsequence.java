package com.watermelon.dp;

/**
 * <h1>LongestCommonSubsequence</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/16
 */
public class LongestCommonSubsequence {
    /**
     * 计算两个字符串的最长公共子序列长度
     * 使用动态规划的方法，dp[i][j]表示text1前i个字符和text2前j个字符的最长公共子序列长度
     * 时间复杂度: O(mn), 空间复杂度: O(mn)
     *
     * @param text1 第一个字符串
     * @param text2 第二个字符串
     * @return 最长公共子序列的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 获取两个字符串的长度
        int m = text1.length();
        int n = text2.length();

        // 创建dp数组,dp[i][j]表示text1[0...i]和text2[0...j]的最长公共子序列长度
        int[][] dp = new int[m][n];

        // 初始化dp[0][0],即两个字符串第一个字符的情况
        if(text1.charAt(0) == text2.charAt(0)) {
            dp[0][0] = 1;
        } else {
            dp[0][0] = 0;
        }

        // 初始化第一列,即text2只有一个字符的情况
        for(int i=1; i<m; i++) {
            if(text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }

        // 初始化第一行,即text1只有一个字符的情况
        for(int j=1; j<n; j++) {
            if(text2.charAt(j) == text1.charAt(0)) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = dp[0][j-1];
            }
        }

        // 填充dp数组
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                // 如果当前字符相等,则最长公共子序列长度加1
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // 如果当前字符不相等,则取左边或上边的最大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // 返回最终结果
        return dp[m-1][n-1];
    }
}