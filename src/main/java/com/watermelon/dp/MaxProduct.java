package com.watermelon.dp;

/**
 * <h1>MaxProduct</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class MaxProduct {

    /**
     * 计算数组中连续子数组的最大乘积
     * 由于数组中可能包含负数，需要同时维护最大值和最小值
     * 当遇到负数时，最大值和最小值会互换
     *
     * @param nums 输入的整数数组
     * @return 连续子数组的最大乘积
     */
    public int maxProduct(int[] nums) {
        // 处理边界情况
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 初始化最大值、最小值和结果为数组第一个元素
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        // 遍历数组，从第二个元素开始
        for (int i = 1; i < nums.length; i++) {
            // 保存当前最大值，因为更新min时会用到
            int temp = max;
            // 更新最大值：当前数、当前数与最大值的乘积、当前数与最小值的乘积三者中的最大值
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            // 更新最小值：当前数、当前数与之前最大值的乘积、当前数与最小值的乘积三者中的最小值
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            // 更新结果：当前结果与新的最大值比较
            result = Math.max(result, max);
        }

        return result;
    }

}