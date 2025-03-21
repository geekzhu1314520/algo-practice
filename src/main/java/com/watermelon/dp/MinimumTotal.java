package com.watermelon.dp;

import java.util.List;

/**
 * <h1>MinimumTotal</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/17
 */
public class MinimumTotal {
    /**
     * 计算三角形从顶部到底部的最小路径和
     * 动态规划解法，从底部向上计算
     *
     * @param triangle 输入的三角形，用二维List表示
     * @return 最小路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 处理空输入情况
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        // 获取三角形的行数
        int n = triangle.size();
        // dp数组存储每个位置到底部的最小路径和
        int[] dp = new int[n + 1];

        // 从底部向上遍历每一行
        for (int i = n - 1; i >= 0; i--) {
            // 遍历当前行的每个元素
            for (int j = 0; j <= i; j++) {
                // 状态转移方程：当前位置的最小路径和 = 下一行相邻位置的最小值 + 当前位置的值
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        // 返回从顶点到底部的最小路径和
        return dp[0];
    }
}