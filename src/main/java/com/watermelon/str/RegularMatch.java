package com.watermelon.str;

/**
 * <h1>RegularMatch</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class RegularMatch {

    /**
     * 实现正则表达式匹配
     * 支持 '.' 和 '*' 两种通配符:
     * '.' 可以匹配任意单个字符
     * '*' 可以匹配零个或多个前面的字符
     *
     * @param s 待匹配的字符串
     * @param p 正则表达式模式
     * @return 是否完全匹配
     */
    public boolean isMatch(String s, String p) {
        // 空值校验
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();
        // dp[i][j]表示s的前i个字符和p的前j个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 空字符串匹配空正则表达式
        dp[0][0] = true;

        // 处理模式串中的星号，如a*可以匹配空字符串
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 动态规划填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 不使用*号前的字符匹配
                    dp[i][j] = dp[i][j - 2];
                    // 使用*号前的字符匹配
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // 当前字符匹配的情况
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 判断字符串s的第i个字符和模式p的第j个字符是否匹配
     *
     * @param s 待匹配的字符串
     * @param p 正则表达式模式
     * @param i s中的位置(1-based)
     * @param j p中的位置(1-based)
     * @return 对应位置的字符是否匹配
     */
    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        // 处理.通配符
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        // 判断字符是否相等
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}