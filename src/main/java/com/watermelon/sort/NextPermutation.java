package com.watermelon.sort;

/**
 * <h1>NextPermutation</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/10
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        // 从右向左找第一个相邻升序对
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            // 从右向左找第一个大于nums[i]的数
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换i,j
            swap(nums, i, j);
        }

        // 将i之后的数反转
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}