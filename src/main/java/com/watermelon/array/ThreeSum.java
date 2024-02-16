package com.watermelon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 17:18
 * @see : https://leetcode.cn/problems/3sum/description/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        // 先排序
        Arrays.sort(nums);

        List<List<Integer>> resultList = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {

            // 没有符合条件的
            if (nums[i] > 0) {
                break;
            }

            // 排重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left = left + 1;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right = right - 1;
                    }

                    left = left + 1;
                    right = right - 1;
                } else if (sum > 0) {
                    right = right - 1;
                } else {
                    left = left + 1;
                }
            }

        }
        return resultList;
    }

}
