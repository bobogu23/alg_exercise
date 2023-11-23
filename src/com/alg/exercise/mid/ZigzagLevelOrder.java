package com.alg.exercise.mid;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class ZigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int i = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.pop();
                if (i % 2 == 0) {
                    level.addLast(node.val);
                }else {
                    level.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(level);
            i++;
        }
        return result;
    }


    public class TreeNode {
        int val;
        ZigzagLevelOrder.TreeNode left;
        ZigzagLevelOrder.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, ZigzagLevelOrder.TreeNode left, ZigzagLevelOrder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
