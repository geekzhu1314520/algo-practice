package com.watermelon.search;

/**
 * <h1>SearchRange</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class SearchRange {

    /**
     * 在排序数组中查找目标值的起始和结束位置
     * @param nums 有序数组
     * @param target 目标值
     * @return 返回目标值的起始和结束下标,如果不存在返回[-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        // 处理边界情况:数组为空或长度为0时返回[-1,-1]
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        // 分别查找目标值的左边界和右边界
        int leftBound = findBound(nums, target, true);
        int rightBound = findBound(nums, target, false);

        return new int[]{leftBound, rightBound};
    }

    /**
     * 二分查找目标值的边界位置
     * @param nums 有序数组
     * @param target 目标值
     * @param isLeft true表示查找左边界,false表示查找右边界
     * @return 返回目标值的边界下标,不存在则返回-1
     */
    private int findBound(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // 计算中间位置,避免整数溢出
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (isLeft) {
                    // 查找左边界:当前位置为数组首位或前一个数不等于目标值时,找到左边界
                    if (mid == 0 || nums[mid - 1] != target) {
                        return mid;
                    }
                    right = mid - 1;  // 继续向左查找
                } else {
                    // 查找右边界:当前位置为数组末位或后一个数不等于目标值时,找到右边界
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    }
                    left = mid + 1;  // 继续向右查找
                }
            } else if (nums[mid] < target) {
                left = mid + 1;  // 目标值在右半部分
            } else {
                right = mid - 1;  // 目标值在左半部分
            }
        }

        return -1;  // 未找到目标值
    }

}