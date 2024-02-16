package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 08:39
 * @see : https://leetcode.cn/problems/container-with-most-water/description/
 */
public class MaxArea {

    public int maxArea(int[] height) {

        if (height == null || height.length < 1) {
            return 0;
        }

        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}
