package com.watermelon.str;

/**
 * <h1>MinWindow</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class MinWindow {

    /**
     * 在字符串s中寻找包含字符串t中所有字符的最小子串
     * 使用滑动窗口算法实现
     *
     * @param s 源字符串
     * @param t 目标字符串
     * @return 包含t中所有字符的最小子串，如果不存在则返回空字符串
     */
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }

        // 记录所需字符的频率
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, count = t.length();

        // 滑动窗口
        for (int right = 0; right < s.length(); right++) {
            // 更新窗口
            if (freq[s.charAt(right)]-- > 0) {
                count--;
            }

            // 找到可行解时收缩窗口
            while (count == 0) {
                // 更新最小子串
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }

                // 收缩左边界
                if (++freq[s.charAt(left++)] > 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

}