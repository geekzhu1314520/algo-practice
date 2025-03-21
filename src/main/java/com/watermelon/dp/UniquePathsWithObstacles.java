package com.watermelon.dp;

/**
 * <h1>UniquePathsWithObstacles</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/16
 */
public class UniquePathsWithObstacles {
    /**
     * 计算带障碍物的网格中从左上角到右下角的不同路径数
     * 使用动态规划解决，dp[i][j]表示到达位置(i,j)的不同路径数
     *
     * @param obstacleGrid 表示网格的二维数组,1表示障碍物,0表示可通过
     * @return 从左上角到右下角的不同路径数
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 处理边界情况
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        // 获取网格的行数和列数
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 初始化第一列,遇到障碍物后的位置都是0
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        // 初始化第一行,遇到障碍物后的位置都是0
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        // 动态规划填表
        // 当前位置的路径数等于上方位置和左方位置的路径数之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // 如果终点是障碍物返回0,否则返回dp数组右下角的值
        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : dp[m - 1][n - 1];
    }
}