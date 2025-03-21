package com.watermelon.tree;

/**
 * <h1>Flatten</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class Flatten {

    /**
     * 将二叉树展开为单链表
     * 展开规则:
     * 1. 展开后的单链表应该与二叉树先序遍历顺序相同
     * 2. 左子树变为右子树,原来的右子树接到左子树展开后的末尾
     *
     * @param root 二叉树的根节点
     */
    public void flatten(TreeNode root) {
        // 如果根节点为空,直接返回
        if (root == null) {
            return;
        }

        // 保存左右子树的引用
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将左子树置空
        root.left = null;

        // 递归展开左右子树
        flatten(left);
        flatten(right);

        // 将展开后的左子树作为右子树
        root.right = left;
        // 找到当前右子树的末尾节点
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        // 将原来的右子树接到末尾
        curr.right = right;
    }

}