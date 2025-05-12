package com.watermelon.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Permute</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/9
 */
public class Permute {

    /**
     * 生成给定数组的所有排列组合
     * @param nums 输入的整数数组
     * @return 包含所有可能排列的列表
     */
    public List<List<Integer>> permute(int[] nums) {
        // 存储最终的排列结果
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 用于标记数字是否已被使用
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    /**
     * 回溯方法，用于生成排列组合
     * @param result 存储所有排列结果的列表
     * @param path 当前正在构建的排列路径
     * @param nums 原始输入数组
     * @param used 标记数字是否已被使用的数组
     */
    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] used) {
        // 当路径长度等于数组长度时，说明找到了一个完整排列
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 遍历所有可能的数字
        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已被使用，则跳过
            if (used[i]) {
                continue;
            }
            // 标记当前数字为已使用
            used[i] = true;
            // 将当前数字添加到路径中
            path.add(nums[i]);
            // 继续递归生成排列
            backtrack(result, path, nums, used);
            // 回溯：移除最后添加的数字
            path.remove(path.size() - 1);
            // 取消标记当前数字的使用状态
            used[i] = false;
        }
    }

}