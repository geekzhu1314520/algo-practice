package com.watermelon.str;

/**
 * <h1>LongestPalindrome</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/9
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 以i为中心的最长回文子串
            int len1 = expandAroundCenter(s, i, i);
            // 以i和i+1为中心的最长回文子串
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 返回以left+1和right-1为中心的回文串的长度
        return right - left - 1;
    }

}