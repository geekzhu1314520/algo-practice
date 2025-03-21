package com.watermelon.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>GenerateParenthesis</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class GenerateParenthesis {

    /**
     * 生成所有可能的有效括号组合
     * @param n 括号对数
     * @return 所有有效的括号组合列表
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * 回溯法生成括号组合
     * @param result 存储所有有效括号组合的列表
     * @param current 当前生成的括号字符串
     * @param open 已使用的左括号数量
     * @param close 已使用的右括号数量
     * @param max 括号对数的最大值
     */
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // 当前字符串长度等于最大长度时,将其添加到结果集
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // 如果左括号数量小于最大值,可以添加左括号
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        // 如果右括号数量小于左括号数量,可以添加右括号
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

}