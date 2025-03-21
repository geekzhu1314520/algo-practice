package com.watermelon.array;

/**
 * <h1>CanJump</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class CanJump {

    /**
     * 判断是否能够跳跃到数组的最后一个位置
     *
     * @param nums 非负整数数组，每个元素代表在该位置可以跳跃的最大长度
     * @return 如果能够到达最后一个位置则返回true，否则返回false
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 记录当前能够到达的最远位置
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            // 当前位置i是否可达(i必须在rightmost范围内)
            if (i <= rightmost) {
                // 更新能够到达的最远位置
                rightmost = Math.max(rightmost, i + nums[i]);
                // 如果最远位置已经超过或达到最后一个位置，说明可以到达终点
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        // 无法到达最后一个位置
        return false;
    }

}