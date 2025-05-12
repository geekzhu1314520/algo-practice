package com.watermelon.dp;

import java.util.Arrays;

/**
 * <h1>CalculateMinimumHP</h1>
 *
 * @author zhujiashuai
 * @since 2025/5/7
 */
public class CalculateMinimumHP {

    /**
     * 计算勇者从地牢左上角到达右下角所需的最小初始生命值
     * 动态规划解法：从右下角向左上角推导
     * dp[i][j] 表示从位置(i,j)到达终点所需的最小初始生命值
     *
     * @param dungeon 地牢数组,dungeon[i][j]表示在位置(i,j)对生命值的影响
     * @return 所需的最小初始生命值
     */
    public int calculateMinimumHP(int[][] dungeon) {
        // 获取地牢的行数和列数
        int m = dungeon.length;
        int n = dungeon[0].length;
        // dp数组多加一行一列便于处理边界情况
        int[][] dp = new int[m + 1][n + 1];
        // 初始化dp数组,填充最大整数值
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 设置终点右边和下边的边界值为1
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        // 从右下角开始,逆向推导到左上角
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 计算当前位置所需的最小生命值
                int minHp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                // 确保生命值至少为1
                dp[i][j] = Math.max(1, minHp);
            }
        }

        // 返回左上角所需的最小初始生命值
        return dp[0][0];
    }

}