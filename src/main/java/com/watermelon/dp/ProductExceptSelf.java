package com.watermelon.dp;

/**
 * <h1>ProductExceptSelf</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class ProductExceptSelf {

    /**
     * 计算数组中除当前元素外其他元素的乘积
     * 要求：不使用除法，时间复杂度 O(n)
     *
     * @param nums 输入的整数数组
     * @return 返回一个数组，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 用于存储最终结果
        int[] answer = new int[n];

        // 第一次遍历：计算每个位置左边所有数字的乘积
        answer[0] = 1;  // 最左边位置左侧没有元素，初始化为1
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 第二次遍历：从右向左遍历，计算右边的乘积并与左边的乘积相乘
        int rightProduct = 1;  // 记录右边元素的乘积
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;  // 将左边乘积和右边乘积相乘
            rightProduct *= nums[i];  // 更新右边乘积
        }

        return answer;
    }

}