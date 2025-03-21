package com.watermelon.sort;

class FindKthLargest2 {

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }

        int pivot = nums[left], i = left - 1, j = right + 1;
        while (i < j) {
            do
                i++;
            while (nums[i] < pivot);
            do
                j--;
            while (nums[j] > pivot);

            if (i < j) {
                swap(nums, i, j);
            }
        }
        if (k <= j)
            return quickSelect(nums, left, j, k);
        else
            return quickSelect(nums, j + 1, right, k);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 6, 7, 8, 9, 10};
        FindKthLargest2 findKthLargest2 = new FindKthLargest2();
        System.out.println(findKthLargest2.findKthLargest(nums, 3));
    }
}