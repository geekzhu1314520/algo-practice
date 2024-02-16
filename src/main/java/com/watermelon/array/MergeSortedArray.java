package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 13:18
 * @see : https://leetcode.cn/problems/merge-sorted-array/description/
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;

        int index = nums1.length - 1;
        while (index >= 0) {

            if (j >= 0 && i < 0) {
                nums1[index] = nums2[j];
                j--;
            }

            if (i >= 0 && j >= 0 && nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else if (i >= 0 && j >= 0 && nums1[i] < nums2[j]) {
                nums1[index] = nums2[j];
                j--;
            }

            index--;
        }

    }

}
