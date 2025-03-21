package com.watermelon.dp;

/**
 * <h1>LongestValidParentheses</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        // left统计左括号数量，right统计右括号数量
        int left = 0, right = 0;
        
        // 从左向右扫描
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            // 当左右括号数量相等时，更新最大长度
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            }
            // 当右括号数量大于左括号时，重置计数器
            if (right > left) {
                left = right = 0;
            }
        }
        
        // 从右向左再扫描一次
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            }
            // 当左括号数量大于右括号时，重置计数器
            if (left > right) {
                left = right = 0;
            }
        }
        
        return maxLen;
    }

}