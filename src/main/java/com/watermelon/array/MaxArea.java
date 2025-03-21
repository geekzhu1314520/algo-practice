package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 08:39
 * @see : https://leetcode.cn/problems/container-with-most-water/description/
 */
public class MaxArea {

    /**
     * 计算容器可以容纳的最大水量
     * 使用双指针法从两端向中间移动，计算可能的最大面积
     *
     * @param height 数组表示的容器高度
     * @return 可以容纳的最大水量
     */
    public int maxArea(int[] height) {
        // 记录最大面积
        int maxArea = 0;
        // 左指针从起点开始
        int left = 0;
        // 右指针从终点开始
        int right = height.length - 1;

        while (left < right) {
            // 计算当前面积：高度取两边较小值 * 宽度
            int area = Math.min(height[left], height[right]) * (right - left);
            // 更新最大面积
            maxArea = Math.max(maxArea, area);

            // 移动较小高度的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;

    }

}
