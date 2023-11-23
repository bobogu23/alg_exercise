package com.alg.exercise.new20231009hot100.tree;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 * 先将左右子节点翻转，然后左右字节点分别翻转它们的子节点
 *
 * @author ben.gu
 */
public class InvertTree_03 {


    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        root.right = l;
        root.left = r;
        return root;
    }
}
