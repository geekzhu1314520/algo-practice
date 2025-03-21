package com.watermelon.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>CalcEquation</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class CalcEquation {

    /**
     * 计算变量之间的除法表达式结果
     * @param equations 包含变量对的列表，如 [["a","b"], ["b","c"]]
     * @param values 对应equations中每个变量对的商值，如 [2.0, 3.0] 表示 a/b=2.0, b/c=3.0
     * @param queries 需要计算的查询列表，如 [["a","c"], ["b","a"]]
     * @return 返回每个查询的结果数组，如果无法计算则返回 -1.0
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int n = equations.size();
        // 初始化并查集的父节点数组和权重数组
        int[] parent = new int[2 * n];
        double[] weight = new double[2 * n];

        // 初始化并查集，每个节点的父节点初始为自身，权重为1.0
        for (int i = 0; i < 2 * n; i++) {
            parent[i] = i;
            weight[i] = 1.0;
        }

        // 存储变量到id的映射关系
        Map<String, Integer> variableToId = new HashMap<>();
        int id = 0;

        // 遍历方程式构建并查集
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            // 为新变量分配id
            if (!variableToId.containsKey(var1)) {
                variableToId.put(var1, id++);
            }
            if (!variableToId.containsKey(var2)) {
                variableToId.put(var2, id++);
            }

            // 合并两个变量所在的集合
            union(variableToId.get(var1), variableToId.get(var2), values[i], parent, weight);
        }

        // 处理每个查询
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String var1 = query.get(0);
            String var2 = query.get(1);

            // 如果查询的变量不存在，返回-1
            if (!variableToId.containsKey(var1) || !variableToId.containsKey(var2)) {
                result[i] = -1.0;
            } else {
                int id1 = variableToId.get(var1);
                int id2 = variableToId.get(var2);
                int root1 = find(id1, parent, weight);
                int root2 = find(id2, parent, weight);

                // 如果两个变量不在同一个集合中，返回-1
                if (root1 != root2) {
                    result[i] = -1.0;
                } else {
                    // 计算查询结果
                    result[i] = weight[id1] / weight[id2];
                }
            }
        }

        return result;
    }

    /**
     * 合并两个节点所在的集合
     * @param x 第一个节点
     * @param y 第二个节点
     * @param value x/y的值
     * @param parent 父节点数组
     * @param weight 权重数组
     */
    private void union(int x, int y, double value, int[] parent, double[] weight) {
        int rootX = find(x, parent, weight);
        int rootY = find(y, parent, weight);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }
    }

    /**
     * 查找节点所属的根节点，并在查找过程中更新权重
     * @param x 要查找的节点
     * @param parent 父节点数组
     * @param weight 权重数组
     * @return 根节点的id
     */
    private int find(int x, int[] parent, double[] weight) {
        if (x != parent[x]) {
            int origin = parent[x];
            parent[x] = find(parent[x], parent, weight);
            weight[x] *= weight[origin];
        }
        return parent[x];
    }

}