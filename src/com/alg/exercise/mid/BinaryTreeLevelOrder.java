package com.alg.exercise.mid;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * <p>
 * 使用队列.
 * root 节点先放入队列,根据当前队列大小,计算出当前一层的节点数,取出队列中指定个数的节点,即遍历完一层节点.
 * 遍历的同时将每一层节点的左右子节点放入队尾
 */
public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        BinaryTreeLevelOrder b = new BinaryTreeLevelOrder();
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(20, t2, t1);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(3, t4, t3);
        List<List<Integer>> lists = b.levelOrder(t5);
        System.err.println(lists);


    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                cur.add(n.val);
                if (n.left != null) {
                    queue.offer(n.left);
                }
                if (n.right != null) {
                    queue.offer(n.right);
                }
            }
            res.add(cur);
        }
        return res;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
