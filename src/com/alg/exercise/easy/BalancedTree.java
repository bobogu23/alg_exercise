package com.alg.exercise.easy;

/**
 * 定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class BalancedTree {


    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //从顶向下 前序遍历,遍历整个树,中途有不平衡的二叉树子树，没法停止
        return Math.abs(height(root.left) - height(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
        //return height1(root) != -1;
    }

    /**
     * 从底向上遍历,如果左右子树高度差超过1，返回-1，直接结束遍历
     *
     * @param root
     * @return
     */
    public static int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height1(root.left);
        int right = height1(root.right);
        if (left == -1 || right == -1 ||
                //左右子树高度差
                Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
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
