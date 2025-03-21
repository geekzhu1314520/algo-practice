package com.watermelon.dp;

/**
 * <h1>LargestRectangleArea</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class LargestRectangleArea {

    /**
     * 计算柱状图中最大的矩形面积
     * 使用单调栈的思想,对于每个柱子,找到左右两边第一个比它矮的柱子
     *
     * @param heights 柱状图的高度数组
     * @return 最大矩形面积
     */
    public int largestRectangleArea(int[] heights) {
        // 获取数组长度
        int n = heights.length;
        // 处理边界情况
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return heights[0];
        }
        // left[i]表示第i个柱子左边第一个比它矮的柱子的下标
        int[] left = new int[n];
        // right[i]表示第i个柱子右边第一个比它矮的柱子的下标
        int[] right = new int[n];

        // 初始化最左边柱子的left值为-1
        left[0] = -1;
        // 从左向右遍历,计算每个柱子的left值
        for (int i = 1; i < n; i++) {
            int t = i - 1;
            // 找到左边第一个比当前柱子矮的柱子
            while (t >= 0 && heights[t] >= heights[i]) {
                t = left[t];
            }
            left[i] = t;
        }

        // 初始化最右边柱子的right值为n
        right[n - 1] = n;
        // 从右向左遍历,计算每个柱子的right值
        for (int i = n - 2; i >= 0; i--) {
            int t = i + 1;
            // 找到右边第一个比当前柱子矮的柱子
            while (t < n && heights[t] >= heights[i]) {
                t = right[t];
            }
            right[i] = t;
        }

        // 计算最大矩形面积
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // 当前柱子能够扩展的最大面积 = 高度 * 宽度
            maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }

}