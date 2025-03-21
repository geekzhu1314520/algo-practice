package com.watermelon.str;

/**
 * <h1>CountSubstrings</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class CountSubstrings {

    /**
     * 计算字符串中回文子串的数量
     * 使用中心扩展法,分别以每个字符为中心向两边扩展,检查是否构成回文串
     *
     * @param s 输入字符串
     * @return 回文子串的总数
     */
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // 中心扩展法
        for (int i = 0; i < n; i++) {
            // 奇数长度回文串,以单个字符为中心
            count += expandAroundCenter(s, i, i);
            // 偶数长度回文串,以两个字符之间的空隙为中心
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    /**
     * 从中心向两边扩展检查回文串
     *
     * @param s 输入字符串
     * @param left 左指针起始位置
     * @param right 右指针起始位置
     * @return 以当前中心能够形成的回文串数量
     */
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        // 当左右指针在合法范围内且对应字符相等时继续扩展
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

}