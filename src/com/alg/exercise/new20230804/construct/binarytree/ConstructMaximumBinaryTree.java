package com.alg.exercise.new20230804.construct.binarytree;

/**
 * https://leetcode.cn/problems/maximum-binary-tree/
 * <p>
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * 找到最大值，记录最大值的位置。
 * 构造左右子树
 */
public class ConstructMaximumBinaryTree {


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int maxPosition = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxPosition = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);

        root.left = build(nums, start, maxPosition - 1);
        root.right = build(nums, maxPosition + 1, end);
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
