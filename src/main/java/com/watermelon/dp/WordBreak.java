package com.watermelon.dp;

import java.util.List;

/**
 * <h1>WordBreak</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class WordBreak {

    /**
     * 判断字符串s是否可以被wordDict中的单词拆分
     * 动态规划解法：dp[i]表示字符串s的前i个字符是否可以被拆分
     *
     * @param s 待拆分的字符串
     * @param wordDict 可用于拆分的单词字典
     * @return 是否可以完全拆分
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 获取字符串长度
        int n = s.length();
        // dp[i]表示s的前i个字符是否可以被拆分下·
        boolean[] dp = new boolean[n + 1];
        // 空字符串可以被拆分
        dp[0] = true;

        // 遍历字符串的每个位置
        for (int i = 1; i <= n; i++) {
            // 尝试用字典中的每个单词去匹配
            for (String word : wordDict) {
                int len = word.length();
                // 如果当前位置i大于等于单词长度，且s的对应子串等于当前单词
                /**
                 * 为什么用 ||
                 * 因为可能有多个单词可以匹配当前位置
                 * 只要有一种匹配方式可行，整体就是可行的
                 * 使用 || 可以保留之前找到的可行解
                 */
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    // dp[i]可以由dp[i-len]转移而来
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }

        return dp[n];
    }

}