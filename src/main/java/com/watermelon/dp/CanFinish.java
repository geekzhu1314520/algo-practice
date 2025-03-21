package com.watermelon.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>CanFinish</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]);
        }

        // 记录节点访问状态：0=未访问，1=正在访问，2=已完成访问
        int[] visited = new int[numCourses];

        // 对每个节点进行DFS
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(adjacency, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] visited, int i) {
        // 如果正在访问，说明有环
        if(visited[i] == 1) return false;
        // 如果已经访问过，直接返回true
        if(visited[i] == 2) return true;

        // 标记为正在访问
        visited[i] = 1;

        // 访问相邻节点
        for(int j : adjacency.get(i)) {
            if(!dfs(adjacency, visited, j)) {
                return false;
            }
        }

        // 标记为已完成访问
        visited[i] = 2;
        return true;
    }


}