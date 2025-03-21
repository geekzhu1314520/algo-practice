package com.watermelon.dp;

/**
 * <h1>FindTargetSumWays</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class FindTargetSumWays {
    /**
     * 计算目标和的所有可能组合数
     * 给定一个非负整数数组nums和一个目标值target，在数组的每个数字前添加'+'或'-'，计算所有可能的组合方式数量
     *
     * @param nums   非负整数数组
     * @param target 目标和
     * @return 所有可能的组合数量
     */
    public int findTargetSumWays(int[] nums, int target) {
        // 计算数组所有元素的和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 如果目标值的绝对值大于数组和，说明无法达到目标值
        if (Math.abs(target) > sum) {
            return 0;
        }

        // 根据数学推导，sum+target必须是偶数，否则无解
        if ((sum + target) % 2 != 0) {
            return 0;
        }

        // 将问题转化为求子集和为pos的方案数
        int pos = (sum + target) / 2;
        // dp[j]表示和为j的组合数量
        int[] dp = new int[pos + 1];
        // 初始化：空集的和为0，只有1种方案
        dp[0] = 1;

        // 遍历每个数字，计算所有可能的组合
        for (int num : nums) {
            // 从后往前遍历，避免重复计算
            for (int j = pos; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[pos];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
        System.out.println(findTargetSumWays.findTargetSumWays(nums, target));
    }
}