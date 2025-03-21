package com.watermelon.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <h1>TopKFrequent</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class TopKFrequent {

    /**
     * 查找数组中出现频率最高的k个元素
     *
     * @param nums 输入的整数数组
     * @param k 需要返回的元素个数
     * @return 返回出现频率最高的k个元素组成的数组
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 使用HashMap统计每个元素出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 创建大顶堆,按照元素出现频率降序排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // 将元素及其频率放入优先队列
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});
        }

        // 取出频率最高的k个元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;

    }

}