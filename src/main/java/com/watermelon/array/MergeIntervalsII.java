package com.watermelon.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>MergeIntervalsII</h1>
 *
 * @author zhujiashuai
 * @since 2025/5/7
 */
public class MergeIntervalsII {

    /**
     * 向已排序的区间数组中插入新区间，并合并重叠的区间
     *
     * @param intervals   已排序的区间数组，每个区间包含起始和结束位置
     * @param newInterval 需要插入的新区间
     * @return 插入并合并后的区间数组
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 用于存储最终结果
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 添加所有在新区间之前的区间（不重叠的部分）
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 处理重叠区间：合并所有与新区间重叠的区间
        while (i < n && intervals[i][0] <= newInterval[1]) {
            // 更新新区间的起始位置为所有重叠区间中的最小起始位置
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            // 更新新区间的结束位置为所有重叠区间中的最大结束位置
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        // 添加合并后的新区间
        result.add(newInterval);

        // 添加所有在新区间之后的区间（不重叠的部分）
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // 将List转换为二维数组并返回
        return result.toArray(new int[result.size()][]);
    }
}