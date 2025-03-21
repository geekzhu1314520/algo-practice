package com.watermelon.dp;

/**
 * <h1>MaximalSquare</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class MaximalSquare {

    /**
     * 计算二维矩阵中最大正方形的面积
     * 使用动态规划的方法，dp[i][j]表示以matrix[i-1][j-1]为右下角的最大正方形边长
     *
     * @param matrix 输入的二维字符矩阵,包含'0'和'1'
     * @return 矩阵中由1组成的最大正方形面积
     */
    public int maximalSquare(char[][] matrix) {
        // 处理边界情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // 获取矩阵的行数和列数
        int rows = matrix.length;
        int cols = matrix[0].length;
        // dp数组用于存储以当前位置为右下角的最大正方形边长
        int[][] dp = new int[rows + 1][cols + 1];
        // 记录最大正方形边长
        int maxSide = 0;

        // 遍历矩阵中的每个元素
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                // 当前位置为1时，计算最大正方形边长
                if (matrix[i - 1][j - 1] == '1') {
                    // 取左边、上边、左上角三个位置的最小值加1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    // 更新最大边长
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        // 返回最大正方形的面积
        return maxSide * maxSide;
    }
}