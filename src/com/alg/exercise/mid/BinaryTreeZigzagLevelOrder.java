package com.alg.exercise.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class BinaryTreeZigzagLevelOrder {
    public static void main(String[] args) {
        //3,9,20,null,null,15,7
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(15);
        TreeNode t3 = new TreeNode(20, t2, t1);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(3, t4, t3);
        BinaryTreeZigzagLevelOrder l = new BinaryTreeZigzagLevelOrder();
        List<List<Integer>> res = l.zigzagLevelOrder(t5);
        System.err.println(res);
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //遍历每一层节点
        //第一层从右往左放节点,第二层从左往右放节点，以此类推
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if(left){
                    level.offerLast(n.val);
                }else {
                    level.offerFirst(n.val);
                }
                if(n.left != null){
                    queue.offer(n.left);
                }
                if(n.right != null){
                    queue.offer(n.right);
                }
            }
            left = !left;
            res.add(level);
        }
        return res;
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
