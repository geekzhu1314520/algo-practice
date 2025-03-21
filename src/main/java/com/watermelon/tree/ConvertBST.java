package com.watermelon.tree;

/**
 * <h1>ConvertBST</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/15
 */
public class ConvertBST {
    // 使用成员变量记录累加和
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 重置累加和
        sum = 0;
        inorderTraverse(root);
        return root;
    }

    // 反向中序遍历：右-根-左
    private void inorderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        // 1. 先遍历右子树
        inorderTraverse(node.right);

        // 2. 处理当前节点
        sum += node.val;    // 累加当前节点值
        node.val = sum;     // 更新节点值为累加和

        // 3. 最后遍历左子树
        inorderTraverse(node.left);
    }
}