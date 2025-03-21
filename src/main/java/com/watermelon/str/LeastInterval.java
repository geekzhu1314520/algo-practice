package com.watermelon.str;

/**
 * <h1>LeastInterval</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class LeastInterval {

    /**
     * 计算完成所有任务所需的最少时间单位
     *
     * @param tasks 任务数组,每个任务由大写字母A-Z表示
     * @param n 相同任务之间的冷却时间
     * @return 完成所有任务的最少时间单位
     */
    public int leastInterval(char[] tasks, int n) {
        // 统计每个任务出现的次数
        int[] count = new int[26];
        // 记录出现次数最多的任务的次数
        int maxCount = 0;
        // 记录出现次数等于maxCount的任务个数
        int maxNum = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            if (maxCount < count[task - 'A']) {
                // 更新最大出现次数和对应的任务个数
                maxCount = count[task - 'A'];
                maxNum = 1;
            } else if (maxCount == count[task - 'A']) {
                // 如果有任务的出现次数等于maxCount,增加maxNum
                maxNum++;
            }
        }

        // 计算最少时间单位:
        // 1. (maxCount-1)*(n+1)+maxNum: 按照冷却时间排列的最小值
        // 2. tasks.length: 任务总数
        // 取两者的较大值作为结果
        return Math.max((maxCount - 1) * (n + 1) + maxNum, tasks.length);
    }

}