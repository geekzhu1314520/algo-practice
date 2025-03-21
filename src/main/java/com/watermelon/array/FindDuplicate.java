package com.watermelon.array;

/**
 * <h1>FindDuplicate</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class FindDuplicate {

    /**
     * 寻找数组中的重复数字
     * 使用快慢指针(Floyd判圈算法)解决问题
     * 数组中包含 n + 1 个整数，数字都在 1 到 n 之间
     * 时间复杂度 O(n)，空间复杂度 O(1)
     *
     * @param nums 输入数组
     * @return 返回重复的数字
     */
    public int findDuplicate(int[] nums) {
        // 初始化快慢指针，都指向第一个元素
        int slow = nums[0];
        int fast = nums[0];

        // 第一阶段：寻找环内的相遇点
        do {
            slow = nums[slow];      // 慢指针每次走一步
            fast = nums[nums[fast]]; // 快指针每次走两步
        } while (slow != fast);

        // 第二阶段：寻找环的入口点（即重复的数字）
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // 返回重复的数字

    }

}