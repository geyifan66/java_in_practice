package com.ewan.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Desc：面试题55 - I. 二叉树的深度
 *
 * @author ewan
 */
public class BinaryTreeDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int deepth = 0;
        while (!queue.isEmpty()) {
            deepth++;

            int n = queue.size();//此处很精妙,在一层中循环N次,但是深度只增加一个

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return deepth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
