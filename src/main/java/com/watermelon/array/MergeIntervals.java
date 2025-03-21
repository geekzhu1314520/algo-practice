package com.watermelon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>MergeIntervals</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/10
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 按照区间起点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 当前区间的起点小于等于上一个区间的终点,说明重叠
            if (interval[0] <= current[1]) {
                // 更新当前区间的终点
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // 不重叠,添加新区间
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}