package com.watermelon.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Subsets</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class Subsets {

    /**
     * 生成给定数组的所有可能子集
     * 使用迭代方法，对于数组中的每个数字，将其添加到已有的子集中形成新的子集
     *
     * @param nums 输入的整数数组
     * @return 返回包含所有可能子集的列表
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 创建结果列表，用于存储所有子集
        List<List<Integer>> result = new ArrayList<>();
        // 添加空集作为初始子集
        result.add(new ArrayList<>());

        // 遍历输入数组中的每个数字
        for (int num : nums) {
            // 获取当前结果集的大小
            int size = result.size();
            // 遍历现有的所有子集
            for (int i = 0; i < size; i++) {
                // 复制现有子集并添加当前数字，形成新的子集
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                // 将新子集添加到结果集中
                result.add(subset);
            }
        }
        return result;
    }

}