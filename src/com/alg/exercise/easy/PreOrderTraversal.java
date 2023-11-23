package com.alg.exercise.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的前序 遍历。
 * 中，左，右的 顺序
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode right1_left = new TreeNode(3);
        root.right= right1;
        right1.left = right1_left;
        System.err.println(preorderTraversal(root));

        root.left =null;
        root.right = new TreeNode(2);
        System.err.println(preorderTraversal(root));

        root.left = null;
        root.right =new TreeNode(2);
        System.err.println(preorderTraversal(root));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root,res);
        return res;

    }

    public static void preorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null){
            return ;
        }
        list.add(root.val);
        preorderTraversal(root.left,list);
        preorderTraversal(root.right,list);
    }
    
        public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
}
