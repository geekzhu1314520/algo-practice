package com.watermelon.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>CombinationSum</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 使用回溯算法解决组合总和问题
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(candidates, target, 0, current, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // 如果目标值为0，说明当前组合的和等于target，将其添加到结果中
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 如果目标值小于0，说明当前组合的和超过了target，直接返回
        if (target < 0) {
            return;
        }

        // 从start开始遍历candidates数组，避免重复组合
        for (int i = start; i < candidates.length; i++) {
            // 将当前数字添加到组合中
            current.add(candidates[i]);
            // 递归调用，注意这里的start仍然是i，因为可以重复使用同一个数字
            backtrack(candidates, target - candidates[i], i, current, result);
            // 回溯，移除最后添加的数字
            current.remove(current.size() - 1);
        }
    }
}