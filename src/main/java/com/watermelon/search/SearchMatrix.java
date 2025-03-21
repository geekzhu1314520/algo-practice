package com.watermelon.search;

/**
 * <h1>SearchMatrix</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class SearchMatrix {

    /**
     * 在二维矩阵中搜索目标值
     * 矩阵特点: 每行从左到右递增，每列从上到下递增
     * 搜索策略: 从左下角开始，大于目标值时上移，小于目标值时右移
     *
     * @param matrix 待搜索的二维矩阵
     * @param target 目标值
     * @return 如果找到目标值返回true，否则返回false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 处理边界情况：矩阵为空或大小为0
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 初始化搜索位置为左下角
        int row = matrix.length - 1;
        int col = 0;

        // 在矩阵范围内循环搜索
        while (row >= 0 && col < matrix[0].length) {
            // 当前值大于目标值，向上移动
            if (matrix[row][col] > target) {
                row--;
            // 当前值小于目标值，向右移动
            } else if (matrix[row][col] < target) {
                col++;
            // 找到目标值
            } else {
                return true;
            }
        }

        // 未找到目标值
        return false;

    }

}