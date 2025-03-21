package com.watermelon.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>Codec</h1>
 *
 * @author zhujiashuai
 * @since 2025/3/13
 */
public class Codec {

    /**
     * 将二叉树序列化为字符串
     * 使用层序遍历的方式，将二叉树转换为字符串表示
     * 格式为: [root,node1,node2,null,...]
     *
     * @param root 二叉树的根节点
     * @return 序列化后的字符串
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // 使用队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                // 空节点用"null"表示
                sb.append("null,");
                continue;
            }
            // 将节点值添加到字符串中
            sb.append(node.val).append(",");
            // 将左右子节点加入队列
            queue.offer(node.left);
            queue.offer(node.right);
        }
        // 删除最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    /**
     * 将序列化的字符串反序列化为二叉树
     * 解析字符串，重建二叉树的结构
     *
     * @param data 序列化后的字符串
     * @return 重建后的二叉树根节点
     */
    public TreeNode deserialize(String data) {
        // 处理空输入和无效输入
        if (data == null || data.length() <= 2) {
            return null;
        }
        // 去掉首尾的方括号并分割字符串
        String[] values = data.substring(1, data.length() - 1).split(",");
        if (values.length == 0) {
            return null;
        }

        // 创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        // 使用队列辅助重建二叉树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        // 遍历数组重建树结构
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();

            // 处理左子节点
            if (i < values.length && !values[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;

            // 处理右子节点
            if (i < values.length && !values[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }

}