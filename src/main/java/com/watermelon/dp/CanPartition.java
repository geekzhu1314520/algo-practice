package com.watermelon.dp;

/**
 * <h1>CanPartition</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class CanPartition {

    /**
     * 判断数组是否可以分割成两个和相等的子集
     * 例如：输入[1,5,11,5]，可以分割成[1,5,5]和[11]，返回true
     *
     * @param nums 输入的整数数组
     * @return 如果可以分割成两个和相等的子集返回true，否则返回false
     */
    public boolean canPartition(int[] nums) {
        // 计算数组总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果总和为奇数，无法分成相等的两部分
        if (sum % 2 != 0) {
            return false;
        }
        // 目标和为总和的一半
        int target = sum / 2;
        // dp[i]表示是否可以从数组中选择若干个数字，使其和为i
        boolean[] dp = new boolean[target + 1];
        // 初始化：空集的和为0是可能的
        dp[0] = true;
        // 对每个数字num，判断是否可以组成j
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                // dp[j]表示当前是否可以组成j
                // dp[j-num]表示是否可以组成j-num，如果可以，则加上num就可以组成j
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

}