package com.alg.exercise.new20230804.bst;

/**
 * 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * <p>
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * **** 二叉搜索树需要满足，左子树的最大值 < root.value < 右子树的最小值
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root,null,null);
    }

    private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValid(root.left,min,root)
                 && isValid(root.right,root,max);

    }


    public class TreeNode {
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
