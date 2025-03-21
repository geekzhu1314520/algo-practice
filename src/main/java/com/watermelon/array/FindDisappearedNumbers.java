package com.watermelon.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>FindDisappearedNumbers</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class FindDisappearedNumbers {

    /**
     * 查找数组中消失的数字
     * 给定一个范围在 1 ≤ a[i] ≤ n 的整型数组，数组中的元素一些出现了多次，另一些只出现一次
     * 找到所有在 [1, n] 范围内没有出现在数组中的数字
     *
     * @param nums 输入数组
     * @return 返回所有在 [1, n] 范围内但不在数组中出现的数字列表
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        // 遍历数组，将每个数对应位置的数标记为负数
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;  // 获取当前数字对应的索引
            if (nums[index] > 0) {              // 如果该位置为正数，则标记为负数
                nums[index] = -nums[index];
            }
        }

        // 再次遍历数组，找出仍为正数的位置，说明这些位置对应的数字缺失
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {                  // 如果数字为正，说明索引i+1没有在数组中出现过
                result.add(i + 1);
            }
        }
        return result;
    }

}