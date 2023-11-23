package com.alg.exercise.easy.topcode20220829;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/?plan=leetcode_75&plan_progress=gb9pjkv
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode r9 = new TreeNode(9);
        TreeNode r20 = new TreeNode(20);
        TreeNode r15 = new TreeNode(15);
        TreeNode r7 = new TreeNode(7);
        r.left =r9;
        r.right =r20;
        r20.right =r7;
        r20.left =r15;

        List<List<Integer>> lists = levelOrder(r);

        print(lists);
    }
    public static void print(List<List<Integer>> list){
        list.forEach( l->{
            StringBuilder stringBuilder = new StringBuilder("[");
            l.forEach(n-> stringBuilder.append(n).append(","));
            String substring = stringBuilder.substring(0,stringBuilder.length() - 1);
            System.err.println(substring+"]");
        });
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        //用一个链表，尾部存放子节点，每次从头遍历 子节点个数的节点
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i< count;i++){
                TreeNode treeNode = queue.pollFirst();
                level.add(treeNode.val);
                if(treeNode.left != null){
                    queue.addLast(treeNode.left);
                }if(treeNode.right!= null){
                    queue.addLast(treeNode.right);
                }
            }
            result.add(level);
        }

        return result;

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
