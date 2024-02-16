package com.watermelon.array;

/**
 * @author zhujiashuai
 * @date: 2024/2/12 10:14
 * @see : https://leetcode.cn/problems/climbing-stairs/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
public class ClimbStairs {

    public int climbStairs(int n) {

        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("入参不正确");
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);

    }

    public int climbStairsV2(int n) {

        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("入参不正确");
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    public int climbStairsV3(int n) {

        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("入参不正确");
        }

        int p, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;

    }

}
