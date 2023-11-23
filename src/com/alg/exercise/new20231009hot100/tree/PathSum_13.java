package com.alg.exercise.new20231009hot100.tree;

/**
 * https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * @author ben.gu
 */
public class PathSum_13 {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int res = path(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    //以root节点为起始节点，向下的节点和为targetSum 的路径数
    public int path(TreeNode root, long targetSum) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            sum++;
        }
        //root节点继续往下，节点之和可能==0
        sum += path(root.left, targetSum - root.val);
        sum += path(root.right, targetSum - root.val);
        return sum;
    }


}
