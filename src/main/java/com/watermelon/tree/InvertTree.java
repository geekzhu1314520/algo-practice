package com.watermelon.tree;

/**
 * <h1>InvertTree</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class InvertTree {

    /**
     * 翻转二叉树
     * 将二叉树的所有节点的左右子树进行交换
     *
     * @param root 二叉树的根节点
     * @return 翻转后的二叉树根节点
     */
    public TreeNode invertTree(TreeNode root) {
        // 如果根节点为空,直接返回null
        if (root == null) {
            return null;
        }
        // 递归翻转左子树
        TreeNode left = invertTree(root.left);
        // 递归翻转右子树
        TreeNode right = invertTree(root.right);
        // 交换左右子树
        root.left = right;
        root.right = left;
        // 返回翻转后的根节点
        return root;
    }

}