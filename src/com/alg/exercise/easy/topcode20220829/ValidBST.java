package com.alg.exercise.easy.topcode20220829;

/**
 * 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/?plan=leetcode_75&plan_progress=gb9pjkv
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 方法1：
 * 左子节点小于根节点，右子节点大于根节点。
 * 根节点的值为r, 则左子树的所有节点的值应该 < r
 * 根节点的值为r, 则右子树的所有节点的值应该 > r
 *
 * 方法2：
 * 根据二叉搜索树的特点，中序遍历这棵树，则节点是升序排列
 *
 */
public class ValidBST {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        System.err.println(inOrderSearch(node));
    }

    public static  boolean isValidBST(TreeNode root) {
        return searchTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static long pre = Long.MIN_VALUE;

    public static boolean inOrderSearch(TreeNode root){
        if(root == null){
            return true;
        }
        if(!inOrderSearch(root.left)){
            return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        return inOrderSearch(root.right);
    }

    public static boolean searchTree(TreeNode node,long lower,long upper){
        if(node == null){
            return true;
        }
        //节点的值不能低于下界，不能高于上界
        if(node.val <= lower || node.val >= upper){
            return false;
        }
        //判断左子树，右子树 是否满足条件
        //根节点是左子树的上界， 是右子树的下界
        return searchTree(node.left,lower,node.val) && searchTree(node.right,node.val,upper);
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

        TreeNode(int val,  TreeNode left,  TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
