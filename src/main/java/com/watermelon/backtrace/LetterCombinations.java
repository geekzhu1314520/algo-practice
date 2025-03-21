package com.watermelon.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>LetterCombinations</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class LetterCombinations {

    /**
     * 根据输入的数字字符串返回所有可能的字母组合
     * 例如："23" -> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     *
     * @param digits 输入的数字字符串(2-9)
     * @return 所有可能的字母组合列表
     */
    public List<String> letterCombinations(String digits) {
        // 处理空输入的情况
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // 定义数字到字母的映射关系,0和1不对应任何字母
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrack(result, digits, "", 0, mapping);
        return result;
    }

    /**
     * 回溯方法,用于生成所有可能的字母组合
     *
     * @param result 存储所有结果的列表
     * @param digits 输入的数字字符串
     * @param current 当前已经形成的字母组合
     * @param index 当前处理到的数字位置
     * @param mapping 数字到字母的映射数组
     */
    private void backtrack(List<String> result, String digits, String current, int index, String[] mapping) {
        // 当处理完所有数字时,将当前组合加入结果集
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // 获取当前数字对应的字母字符串
        String letters = mapping[digits.charAt(index) - '0'];
        // 遍历当前数字对应的每个字母
        for (char letter : letters.toCharArray()) {
            backtrack(result, digits, current + letter, index + 1, mapping);
        }
    }

}