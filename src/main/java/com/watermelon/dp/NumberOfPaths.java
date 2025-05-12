package com.watermelon.dp;

/**
 * <h1>NumberOfPaths</h1>
 *
 * @author zhujiashuai
 * @since 2025/5/4
 */
public class NumberOfPaths {

    /**
     * 计算从左上角到右下角的路径数，要求路径和能被k整除
     *
     * @param grid 二维网格,每个格子包含一个非负整数
     * @param k    路径和需要被k整除
     * @return 满足条件的路径数量
     */
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // 取模常量,防止结果溢出
        int MOD = 1000000007;

        // dp[i][j][v] 表示到达(i,j)位置，路径和mod k = v的路径数
        int[][][] dp = new int[m][n][k];

        // 初始化起点(0,0)位置
        dp[0][0][grid[0][0] % k] = 1;

        // 处理第一行,只能从左边到达
        for (int j = 1; j < n; j++) {
            int val = grid[0][j];
            for (int v = 0; v < k; v++) {
                dp[0][j][(v + val) % k] = dp[0][j - 1][v];
            }
        }

        // 处理第一列,只能从上边到达
        for (int i = 1; i < m; i++) {
            int val = grid[i][0];
            for (int v = 0; v < k; v++) {
                dp[i][0][(v + val) % k] = dp[i - 1][0][v];
            }
        }

        // 处理其他位置,可以从上边或左边到达
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int val = grid[i][j];
                for (int v = 0; v < k; v++) {
                    // 当前位置的路径数等于从上边来的路径数加上从左边来的路径数
                    dp[i][j][(v + val) % k] = (dp[i - 1][j][v] + dp[i][j - 1][v]) % MOD;
                }
            }
        }

        // 返回到达终点且路径和能被k整除的路径数
        return dp[m - 1][n - 1][0];
    }

}