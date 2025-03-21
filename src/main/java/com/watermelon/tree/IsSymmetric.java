package com.watermelon.tree;

/**
 * <h1>IsSymmetric</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/12
 */
public class IsSymmetric {

    /**
     * 判断一棵二叉树是否是对称的
     * 对称二叉树定义: 二叉树的左右子树镜像对称
     *
     * @param root 二叉树的根节点
     * @return 如果二叉树是对称的返回true，否则返回false
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    /**
     * 递归检查两个子树是否镜像对称
     *
     * @param left 左子树节点
     * @param right 右子树节点
     * @return 如果两个子树镜像对称返回true，否则返回false
     */
    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }

}