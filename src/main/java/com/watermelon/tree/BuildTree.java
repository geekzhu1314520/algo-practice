package com.watermelon.tree;

/**
 * <h1>BuildTree</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/11
 */
public class BuildTree {

    // 前序遍历的索引
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        // 如果没有节点要处理
        if (left > right) {
            return null;
        }

        // 创建当前根节点
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // 在中序遍历中找到根节点的位置
        int rootPosition = findIndex(inorder, rootValue, left, right);

        // 先构建左子树，再构建右子树
        root.left = buildTreeHelper(preorder, inorder, left, rootPosition - 1);
        root.right = buildTreeHelper(preorder, inorder, rootPosition + 1, right);

        return root;
    }

    private int findIndex(int[] inorder, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

}