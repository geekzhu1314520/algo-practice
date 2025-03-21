package com.watermelon.dp;

/**
 * <h1>DailyTemperatures</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class DailyTemperatures {

    /**
     * 计算每日温度数组中，对于每个元素，需要等待多少天才能遇到更高的温度
     * 使用单调栈的方法解决，栈中存储温度的下标
     *
     * @param temperatures 每日温度数组
     * @return 返回一个数组，其中第 i 个元素表示需要等待的天数，如果之后没有更高温度则为0
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // 获取温度数组长度
        int n = temperatures.length;
        // 初始化结果数组
        int[] answer = new int[n];
        // 创建栈来存储温度的下标
        int[] stack = new int[n];
        // 栈顶指针初始化为-1
        int top = -1;

        for (int i = 0; i < n; i++) {
            // 当栈不为空且当前温度大于栈顶温度时，更新结果数组
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                // 获取栈顶元素下标并出栈
                int prevIndex = stack[top--];
                // 计算等待天数并存入结果数组
                answer[prevIndex] = i - prevIndex;
            }
            // 将当前温度的下标入栈
            stack[++top] = i;
        }

        return answer;
    }
}