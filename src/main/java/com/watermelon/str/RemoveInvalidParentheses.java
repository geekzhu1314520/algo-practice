package com.watermelon.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>RemoveInvalidParentheses</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class RemoveInvalidParentheses {

    /**
     * 删除最少数量的无效括号，使输入字符串有效
     * 有效字符串需满足：
     * 1. 左右括号数量相等
     * 2. 任意位置左括号数量大于等于右括号数量
     *
     * @param s 输入的可能包含无效括号的字符串
     * @return 所有可能的有效字符串结果
     */
    public List<String> removeInvalidParentheses(String s) {
        // 计算需要删除的左右括号数量
        int leftToRemove = 0, rightToRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftToRemove++;  // 遇到左括号，计数加1
            } else if (c == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;  // 如果有未匹配的左括号，则抵消一个
                } else {
                    rightToRemove++;  // 否则这个右括号是多余的，需要删除
                }
            }
        }

        Set<String> result = new HashSet<>();  // 使用Set去重
        dfs(s, 0, leftToRemove, rightToRemove, 0, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    /**
     * 深度优先搜索处理字符串
     *
     * @param s        原始字符串
     * @param i        当前处理的字符位置
     * @param leftRem  还需删除的左括号数量
     * @param rightRem 还需删除的右括号数量
     * @param open     当前未匹配的左括号数量
     * @param sb       当前构建的字符串
     * @param result   存储所有有效结果的集合
     */
    private void dfs(String s, int i, int leftRem, int rightRem, int open, StringBuilder sb, Set<String> result) {
        // 到达字符串末尾时检查是否是有效结果
        if (i == s.length()) {
            if (leftRem == 0 && rightRem == 0 && open == 0) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(i);
        int len = sb.length();  // 记录当前StringBuilder长度，用于回溯

        // 处理需要删除字符的情况
        if (c == '(' && leftRem > 0) {  // 可以删除左括号
            dfs(s, i + 1, leftRem - 1, rightRem, open, sb, result);
        }
        if (c == ')' && rightRem > 0) {  // 可以删除右括号
            dfs(s, i + 1, leftRem, rightRem - 1, open, sb, result);
        }

        // 处理保留字符的情况
        sb.append(c);
        if (c == '(') {  // 保留左括号
            dfs(s, i + 1, leftRem, rightRem, open + 1, sb, result);
        } else if (c == ')' && open > 0) {  // 保留右括号，前提是有未匹配的左括号
            dfs(s, i + 1, leftRem, rightRem, open - 1, sb, result);
        } else if (c != '(' && c != ')') {  // 保留其他字符
            dfs(s, i + 1, leftRem, rightRem, open, sb, result);
        }
        sb.setLength(len);  // 回溯，恢复StringBuilder到之前的状态
    }

}