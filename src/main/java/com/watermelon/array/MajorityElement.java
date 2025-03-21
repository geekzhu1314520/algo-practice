package com.watermelon.array;

/**
 * <h1>MajorityElement</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class MajorityElement {

    /**
     * 寻找数组中的多数元素（出现次数超过数组长度一半的元素）
     * 使用摩尔投票算法实现，时间复杂度O(n)，空间复杂度O(1)
     *
     * @param nums 输入的整数数组
     * @return 返回数组中的多数元素
     */
    public int majorityElement(int[] nums) {
        // 计数器，用于记录当前候选数字的出现次数
        int count = 0;
        // 候选数字，初始化为数组第一个元素
        int candidate = nums[0];

        // 遍历数组中的每个元素
        for (int num : nums) {
            // 当计数器为0时，更换候选数字
            if (count == 0) {
                candidate = num;
            }
            // 当前数字等于候选数字时count+1，否则count-1
            count += (num == candidate) ? 1 : -1;
        }

        // 返回最终的候选数字，即为多数元素
        return candidate;

    }

}