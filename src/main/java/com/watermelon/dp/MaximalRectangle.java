package com.watermelon.dp;

/**
 * <h1>MaximalRectangle</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class MaximalRectangle {

    /**
     * 计算二维矩阵中最大的矩形面积
     * 解题思路:
     * 1. 将矩阵每一行视为柱状图的底部,计算每个位置向上的连续1的高度
     * 2. 对每一行使用单调栈计算左右边界,求得最大矩形面积
     *
     * @param matrix 二维字符矩阵,只包含字符'0'和'1'
     * @return 最大矩形面积
     */
    public int maximalRectangle(char[][] matrix) {
        // 处理边界情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // heights[i][j]表示(i,j)位置上方连续1的个数
        int[][] heights = new int[m][n];

        // 计算每个位置的高度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 当前位置是1时,高度为上一行高度+1
                    heights[i][j] = (i == 0 ? 0 : heights[i-1][j]) + 1;
                }
            }
        }

        int maxArea = 0;
        // 对每一行使用单调栈计算最大矩形面积
        for (int i = 0; i < m; i++) {
            // left[j]表示第j个位置左边第一个小于其高度的位置
            int[] left = new int[n];
            // right[j]表示第j个位置右边第一个小于其高度的位置
            int[] right = new int[n];
            // 用于模拟单调栈的数组
            int[] stack = new int[n + 1];
            int top = -1;

            // 从左向右遍历,计算左边界
            for (int j = 0; j < n; j++) {
                // 维护单调递增栈
                while (top != -1 && heights[i][stack[top]] >= heights[i][j]) {
                    top--;
                }
                left[j] = top == -1 ? 0 : stack[top] + 1;
                stack[++top] = j;
            }

            // 从右向左遍历,计算右边界
            top = -1;
            for (int j = n - 1; j >= 0; j--) {
                // 维护单调递增栈
                while (top != -1 && heights[i][stack[top]] >= heights[i][j]) {
                    top--;
                }
                right[j] = top == -1 ? n : stack[top];
                stack[++top] = j;
            }

            // 计算当前行中的最大矩形面积
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, heights[i][j] * (right[j] - left[j]));
            }
        }

        return maxArea;

    }

}