package com.watermelon.tree;

/**
 * <h1>PathSum</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class PathSum {

    /**
     * 计算二叉树中所有路径和等于目标值的路径数量
     * 通过递归遍历每个节点作为起点，计算所有可能的路径
     *
     * @param root 二叉树根节点
     * @param targetSum 目标路径和
     * @return 满足条件的路径数量
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    /**
     * 深度优先搜索计算以当前节点为起点的路径和等于目标值的路径数量
     *
     * @param node 当前节点
     * @param sum 剩余需要的路径和
     * @return 满足条件的路径数量
     */
    private int dfs(TreeNode node, long sum) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val == sum) {
            count++;
        }

        count += dfs(node.left, sum - node.val);
        count += dfs(node.right, sum - node.val);

        return count;

    }

}