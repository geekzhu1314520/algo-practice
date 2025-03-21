package com.watermelon.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <h1>LongestConsecutive</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;

    }

}