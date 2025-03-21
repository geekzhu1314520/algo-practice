package com.watermelon.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>SubarraySum</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        // 用于存储前缀和及其出现次数
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);  // 初始化，前缀和为0出现1次

        int sum = 0;  // 当前前缀和
        int count = 0;  // 结果计数

        for (int num : nums) {
            sum += num;
            // 如果存在一个前缀和，使得 sum - k = 该前缀和
            // 则找到了一个和为k的子数组
            count += prefixSum.getOrDefault(sum - k, 0);
            // 更新当前前缀和的出现次数
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}