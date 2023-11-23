package com.alg.exercise.new20230523.tree;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 *
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 *
 * 两节点之间路径的 长度 由它们之间边数表示。
 *
 * 解：左右子树最大深度之和。
 */
public class DiameterOfBinaryTree_03 {

    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);

        return maxDiameter;
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int lefMax = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter,lefMax+right);
        return Math.max(lefMax,right)+1;
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
