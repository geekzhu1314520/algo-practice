package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/16 16:19
 * @description:
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return digits;
        }

        int i = digits.length - 1;
        do {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                break;
            }
            i--;
        }
        while (i >= 0);

        if (digits[0] == 0) {
            int[] nums = new int[digits.length + 1];
            nums[0] = 1;
//            System.arraycopy(digits, 0, nums, 1, digits.length);
            return nums;
        }
        return digits;
    }

}
