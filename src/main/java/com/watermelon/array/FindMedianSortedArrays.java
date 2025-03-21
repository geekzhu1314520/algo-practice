package com.watermelon.array;

/**
 * <h1>FindMedianSortedArrays</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/10
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        
        // 遍历到中位数位置
        for (int i = 0; i <= len/2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] <= nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        
        // 如果总长度为奇数，返回right；如果为偶数，返回(left + right)/2
        return len % 2 == 0 ? (left + right) / 2.0 : right;
    }

}