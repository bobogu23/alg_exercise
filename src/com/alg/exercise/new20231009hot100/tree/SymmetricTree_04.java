package com.alg.exercise.new20231009hot100.tree;

/**
 * https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *  根节点为null是对称的。不为null，则左子树与右子树对称，则它对称
 *
 * 如何判断左右子树对称？
 *  左节点的值 =  右节点的值，且 左节点的左子树 与右节点的右子树对称，左节点的右子树与右节点的左子树对称，
 *
 * @author ben.gu
 */
public class SymmetricTree_04 {


    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if(left == null && right ==  null){
            return  true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && isSymmetric(left.left,right.right)
                && isSymmetric(left.right,right.left);

    }


}
