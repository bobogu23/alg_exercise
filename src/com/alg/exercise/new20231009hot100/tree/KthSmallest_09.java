package com.alg.exercise.new20231009hot100.tree;

/**
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @author ben.gu
 */
public class KthSmallest_09 {

    public static void main(String[] args) {
        TreeNode  root = new TreeNode(3 );
        TreeNode  n1 = new TreeNode(1);
        TreeNode  n2 = new TreeNode(2);
        TreeNode  n4 = new TreeNode(4);
        root.left = n1;
        n1.right = n2;
        root.right=n4;

        KthSmallest_09 k = new KthSmallest_09();
        int num = k.kthSmallest(root, 1);
        System.err.println(num);

    }

    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return target;
    }

    private int target = -1 ;
    private int count = 0;

    private void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count == k){
            target = root.val;
            return;
        }
        inorder(root.right,k);
    }
}
