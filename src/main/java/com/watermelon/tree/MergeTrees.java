package com.watermelon.tree;

/**
 * <h1>MergeTrees</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class MergeTrees {

    /**
     * 合并两个二叉树
     * 将两个二叉树合并为一个新的二叉树。合并规则是:如果两个节点重叠,将值相加作为新节点的值
     *
     * @param root1 第一棵二叉树的根节点
     * @param root2 第二棵二叉树的根节点
     * @return 合并后的新二叉树的根节点
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果root1为空,直接返回root2
        if (root1 == null) {
            return root2;
        }
        // 如果root2为空,直接返回root1
        if (root2 == null) {
            return root1;
        }
        // 创建新节点,值为两个节点的值之和
        TreeNode merged = new TreeNode(root1.val + root2.val);
        // 递归合并左子树
        merged.left = mergeTrees(root1.left, root2.left);
        // 递归合并右子树
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

}