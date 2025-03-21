package com.watermelon.tree;

/**
 * <h1>NumTrees</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class NumTrees {

    /**
     * 计算给定节点数量可以生成的不同二叉搜索树的数量
     * 使用动态规划的方法求解:
     * - dp[i]表示i个节点可以生成的不同二叉搜索树的数量
     * - 对于每个节点j作为根节点时,左子树节点个数为j-1,右子树节点个数为i-j
     * - 最终的dp[i]是所有可能根节点情况的累加
     *
     * @param n 节点的数量
     * @return 可以生成的不同二叉搜索树的数量
     */
    public int numTrees(int n) {
        // 处理边界情况
        if (n <= 1) {
            return 1;
        }
        // 创建dp数组存储中间结果
        int[] dp = new int[n + 1];
        // 初始化边界条件
        dp[0] = 1;
        dp[1] = 1;
        // 计算每个节点数对应的二叉搜索树数量
        for (int i = 2; i <= n; i++) {
            // 遍历所有可能的根节点
            for (int j = 1; j <= i; j++) {
                // 当前根节点为j时的二叉搜索树数量 = 左子树数量 * 右子树数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];

    }

}