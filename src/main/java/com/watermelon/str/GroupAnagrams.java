package com.watermelon.str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>GroupAnagrams</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class GroupAnagrams {

    /**
     * 将字符串数组中的字母异位词分组
     * 字母异位词指字母相同，但排列不同的字符串
     *
     * @param strs 输入的字符串数组
     * @return 按字母异位词分组后的结果列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // 用map存储排序后的字符串(key)与对应的原字符串列表(value)
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将字符串转为字符数组并排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 排序后的字符串作为key
            String key = new String(chars);
            // 获取key对应的列表,如果不存在则创建新列表
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // 将原字符串添加到列表中
            list.add(str);
            map.put(key, list);
        }
        // 返回所有分组的列表
        return new ArrayList<>(map.values());
    }

}