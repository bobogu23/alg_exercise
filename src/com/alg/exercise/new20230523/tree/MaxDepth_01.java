package com.alg.exercise.new20230523.tree;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 解：左右子树最大深度+1
 */
public class MaxDepth_01 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        root.left =l1;

        TreeNode r1 = new TreeNode(20);
        root.right=r1;

        TreeNode r1l1 = new TreeNode(15);
        TreeNode r1r1 = new TreeNode(7);

        r1.left=r1l1;
        r1.right=r1r1;

        MaxDepth_01 maxDepth = new MaxDepth_01();
        System.err.println(maxDepth.maxDepth(root));




    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right))+1;
    }

    public int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right))+1;
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


