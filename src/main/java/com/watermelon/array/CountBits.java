package com.watermelon.array;

/**
 * <h1>CountBits</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class CountBits {
    /**
     * 计算从0到n的每个整数的二进制表示中1的个数
     *
     * @param n 输入的整数n，表示要计算的范围[0,n]
     * @return 返回一个整数数组，其中ans[i]表示整数i的二进制表示中1的个数
     */
    public int[] countBits(int n) {
        // 创建长度为n+1的数组用于存储结果
        int[] ans = new int[n + 1];
         // 遍历0到n的每个数
        for (int i = 0; i <= n; i++) {
            // 使用Integer.bitCount计算整数i的二进制表示中1的个数
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

}