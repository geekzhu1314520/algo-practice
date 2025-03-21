package com.watermelon.search;

/**
 * <h1>SortColors</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class SortColors {

    /**
     * 给定一个包含红色、白色和蓝色的数组，将其按照红色(0)、白色(1)、蓝色(2)的顺序进行原地排序
     * 使用双指针法，一次遍历完成排序
     * 时间复杂度：O(n)，空间复杂度：O(1)
     *
     * @param nums 待排序的数组，其中元素只包含0、1、2三种值
     */
    public void sortColors(int[] nums) {
        // 处理边界情况
        if (nums == null || nums.length <= 1) {
            return;
        }

        // p0指向0的右边界，p2指向2的左边界，curr为当前遍历位置
        int p0 = 0;
        int p2 = nums.length - 1;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 遇到0，与p0位置交换，并将两个指针都向右移动
                swap(nums, p0, curr);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                // 遇到2，与p2位置交换，并将p2向左移动
                swap(nums, p2, curr);
                p2--;
            } else {
                // 遇到1，直接跳过
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}