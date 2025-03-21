package com.watermelon.dp;

/**
 * <h1>RobII</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/14
 */
public class RobII {

    /**
     * 打家劫舍III - 在二叉树上进行打劫
     * 不能同时打劫相邻的节点，求能打劫到的最大金额
     * @param root 二叉树的根节点
     * @return 能打劫到的最大金额
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    /**
     * 递归计算打劫节点的最大收益
     * @param root 当前节点
     * @return int[2] 数组，其中:
     *         result[0] 表示不抢当前节点能获得的最大金额
     *         result[1] 表示抢当前节点能获得的最大金额
     */
    private int[] robInternal(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];
        int[] left = robInternal(root.left);   // 递归计算左子树的结果
        int[] right = robInternal(root.right); // 递归计算右子树的结果

        // 不抢当前节点时，可以选择抢或不抢子节点
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 抢当前节点时，子节点就不能抢了
        result[1] = root.val + left[0] + right[0];

        return result;
    }

}