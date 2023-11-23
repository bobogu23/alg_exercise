package com.alg.exercise.new20230523.tree;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 解：左右子树的深度+1
 */
public class MaxDepth_04 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode r1l1 = new TreeNode(15);
        TreeNode r1r1 = new TreeNode(7);

        root.left = l1;
        root.right = r1;

        r1.left = r1l1;
        r1.right = r1r1;


        MaxDepth_04  m = new MaxDepth_04();

        System.err.println(m.maxDepth(root));


    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
