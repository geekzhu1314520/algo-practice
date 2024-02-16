package com.watermelon.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 14:11
 * @see : https://leetcode.cn/problems/two-sum/description/
 */
public class TwoSum2 {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] {};
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[] {};
    }
}
