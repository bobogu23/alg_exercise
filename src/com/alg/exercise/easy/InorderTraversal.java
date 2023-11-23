package com.alg.exercise.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * 左，中，右的 顺序
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode right1_left = new TreeNode(3);
        root.right= right1;
        right1.left = right1_left;
        System.err.println(inorderTraversal(root));

        root.left = new TreeNode(2);
        root.right =null;
        System.err.println(inorderTraversal(root));

        root.left = null;
        root.right =new TreeNode(2);
        System.err.println(inorderTraversal(root));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root,res);
        return res;

    }

    public static void inorderTraversal(TreeNode root,List<Integer> list) {
        if(root == null){
            return ;
        }
        inorderTraversal(root.left,list);
        list.add(root.val);
        inorderTraversal(root.right,list);
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
