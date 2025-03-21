package com.watermelon.tree;

/**
 * <h1>MaxPathSum</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/10
 */
public class MaxPathSum {

    /**
     * 计算二叉树中的最大路径和
     * 路径被定义为从树中的任意节点出发，沿着树的边走到任意节点的序列
     * 路径中至少包含一个节点，且不一定经过根节点
     *
     * @param root 二叉树的根节点
     * @return 最大路径和
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxSum = {Integer.MIN_VALUE};
        maxGain(root, maxSum);
        return maxSum[0];
    }

    /**
     * 递归计算每个节点的最大贡献值
     * 节点的最大贡献值定义为:以该节点为起点的一条路径,所能提供的最大路径和
     *
     * @param node 当前节点
     * @param maxSum 保存全局最大路径和的数组
     * @return 以当前节点为起点的最大贡献值
     */
    private int maxGain(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值,如果贡献值为负则取0
        int leftGain = Math.max(maxGain(node.left, maxSum), 0);
        int rightGain = Math.max(maxGain(node.right, maxSum), 0);

        // 当前节点的最大路径和 = 当前节点值 + 左子树贡献 + 右子树贡献
        int priceNewPath = node.val + leftGain + rightGain;
        maxSum[0] = Math.max(maxSum[0], priceNewPath);

        // 返回节点的最大贡献值,只能选择左右子树中的一条路径
        return node.val + Math.max(leftGain, rightGain);
    }

}