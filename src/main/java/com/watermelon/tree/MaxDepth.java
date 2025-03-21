package com.watermelon.tree;

/**
 * <h1>MaxDepth</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}