package com.alg.exercise.new20230803.binarytree;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertBinaryTree {

    /**
     * 是否可以遍历，或者递归。每个节点需要做什么操作？
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 子节点翻转，
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        //当前节点的左右节点交换
        root.left = r;
        root.right = l;
        return root;
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
