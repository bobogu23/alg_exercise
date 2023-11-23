package com.alg.exercise.mid.topcode20221107;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?favorite=2cktkvj
 * 二叉树展开成链表。
 * <p>
 * 将根节点的左子树拉平，将右子树拉平，
 * 然后将右子树的根节点接到左子树的尾部，
 * 最后将左子树做为根节点的右子树。
 */
public class FlattenBinaryTree_114 {

    public static void main(String[] args) {
        FlattenBinaryTree_114 t = new FlattenBinaryTree_114();
        TreeNode r = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r.left = r2;
        r.right = r5;

        r2.left = r3;
        r2.right = r4;

        r5.right = r6;

        t.flatten(r);

        r.print();


    }


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            flatten(left);
        }
        if (right != null) {
            flatten(right);
        }

        TreeNode newLeft = appendTail(left, right);
        root.left = null;
        root.right = newLeft;
    }

    private TreeNode appendTail(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        }
        TreeNode n = left;
        while (n.right != null) {
            n = n.right;
        }
        n.right = right;
        return left;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public void print(){
            System.err.println(val);
            if(left != null){
                left.print();
            }
            if(right != null){
                right.print();
            }
        }

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
