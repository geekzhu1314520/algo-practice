package com.watermelon.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h1>MaxSlidingWindow</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 特判
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // 双端队列存储下标
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 1. 移除超出窗口的元素
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. 移除所有小于当前元素的值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 3. 添加当前元素
            deque.offerLast(i);

            // 4. 窗口形成后记录结果
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

}