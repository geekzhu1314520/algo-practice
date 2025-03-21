package com.watermelon.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>ReconstructQueue</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class ReconstructQueue {

    /**
     * 根据身高和前面人数重建队列
     *
     * @param people 二维数组 people[i] = [hi, ki] 表示第 i 个人的身高为 hi，前面正好有 ki 个身高大于或等于 hi 的人
     * @return 重建后的队列
     */
    public int[][] reconstructQueue(int[][] people) {

        // 按照身高降序、k值升序排序
        // 身高不同时按身高降序排列，身高相同时按k值升序排列
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        // 按照k值插入到对应位置
        // 因为是按身高降序排列，所以在插入时，前面的人身高都比当前的人高
        // 直接把当前的人插入到k值对应的位置即可
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        // 将List转换为二维数组返回
        return list.toArray(new int[list.size()][]);
    }

}