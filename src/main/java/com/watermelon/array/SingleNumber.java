package com.watermelon.array;

/**
 * <h1>SingleNumber</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class SingleNumber {

    /**
     * 查找数组中只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
     * 使用异或运算的特性:
     * 1. a^a=0
     * 2. a^0=a
     * 3. 异或运算满足交换律
     *
     * @param nums 输入的整数数组
     * @return 数组中只出现一次的那个元素
     */
    public int singleNumber(int[] nums) {
        // 初始化结果为0
        int result = 0;
        // 遍历数组中的每个数字
        for (int num : nums) {
            // 使用异或运算，相同的数字会被消除，最后剩下单独的数字
            result ^= num;
        }
        return result;

    }
}