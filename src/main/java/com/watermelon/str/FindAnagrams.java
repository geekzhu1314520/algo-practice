package com.watermelon.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>FindAnagrams</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class FindAnagrams {

    /**
     * 查找字符串s中所有p的异位词的起始索引
     * 异位词指字母相同，但排列不同的字符串
     * 使用滑动窗口方法实现
     *
     * @param s 源字符串
     * @param p 目标字符串
     * @return 所有异位词的起始索引列表
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 边界条件检查
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        // 使用数组记录字符出现频次，26对应小写字母
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // 统计p中字符频次
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化第一个窗口的字符频次
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口是否是异位词
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // 滑动窗口，逐个检查后续窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 移除窗口最左边的字符频次
            sCount[s.charAt(i - p.length()) - 'a']--;
            // 添加新进入窗口的字符频次
            sCount[s.charAt(i) - 'a']++;

            // 比较当前窗口字符频次是否与p相同
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

}