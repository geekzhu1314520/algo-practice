package com.watermelon.stack;

import java.util.Stack;

/**
 * @author zhujiashuai
 * @date: 2024/4/7 21:15
 * @see :https://leetcode.cn/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character top = stack.pop();
                if (s.charAt(i) == ')' && top != '(') {
                    return false;
                }

                if (s.charAt(i) == '}' && top != '{') {
                    return false;
                }

                if (s.charAt(i) == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
