package com.watermelon.sort;

class FindKthLargest1 {

    public static int findKthLargest(int[] nums, int k) {
        QuickSort.quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findKthLargest(nums, 3));
    }
}