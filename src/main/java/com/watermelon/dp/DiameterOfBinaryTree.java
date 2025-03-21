package com.watermelon.dp;

/**
 * <h1>DiameterOfBinaryTree</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class DiameterOfBinaryTree {
    // 用于记录最大直径
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    /**
     * 计算从当前节点到叶子节点的最大长度
     *
     * @param node 当前节点
     * @return 从当前节点到叶子节点的最大长度
     */
    private int dfs(TreeNode node) {
        // 空节点的高度为0
        if (node == null) {
            return 0;
        }

        // 计算左子树的最大长度
        int leftPath = dfs(node.left);
        // 计算右子树的最大长度
        int rightPath = dfs(node.right);

        // 更新最大直径
        // 直径 = 左路径长度 + 右路径长度
        maxDiameter = Math.max(maxDiameter, leftPath + rightPath);

        // 返回以当前节点为起点的最大路径长度
        return Math.max(leftPath, rightPath) + 1;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
