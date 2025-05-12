package com.watermelon.dp;

import java.util.Arrays;

/**
 * <h1>RobIV</h1>
 *
 * @author zhujiashuai
 * @since 2025/5/8
 */
public class RobIV {

    /**
     * 计算窃取k个房屋所需的最小能力值
     * 使用二分查找的方式来寻找最小能力值
     *
     * @param nums 房屋中财物的数组
     * @param k    需要窃取的房屋数量
     * @return 所需的最小能力值
     */
    public int minCapability(int[] nums, int k) {
        // 二分查找的范围是数组中的最小值到最大值
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 检查是否能用mid作为窃取能力偷到k个房子
            if (canStealK(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 判断以给定能力值是否能偷到k个房子
     * @param capability 当前尝试的窃取能力值
     */
    private boolean canStealK(int[] nums, int k, int capability) {
        // count表示能偷到的房子数量
        int count = 0;
        // 遍历数组，用贪心的方式计算
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                // 如果当前房子可以偷（值小于等于能力值）
                count++;
                i++; // 跳过下一个房子（因为不能偷相邻的）
            }
        }
        return count >= k;
    }
}
