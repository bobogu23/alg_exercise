package com.alg.exercise.new20230804.construct.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class ConstructTreeFromInPostOrder {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(9);
        TreeNode r = new TreeNode(20);

        TreeNode l1 = new TreeNode(15);
        TreeNode r1 = new TreeNode(7);

        root.left =l;
        root.right =r;

        r.left =l1;
        r.right =r1;

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        ConstructTreeFromInPostOrder c = new ConstructTreeFromInPostOrder();

        TreeNode tree = c.buildTree(inorder,postorder);





    }

    private Map<Integer, Integer> inorderNodeIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderNodeIndex.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] postorder, int postStart, int postEnd,
                              int[] inorder, int inStart, int inEnd) {

        if (postStart > postEnd) {
            return null;
        }
        //后序遍历，根节点在数组末尾
        int rootValue = postorder[postEnd];
        //找到根节点，
        TreeNode root = new TreeNode(rootValue);
        // 中序遍历，root节点的位置
        int inOrderRootIndex = inorderNodeIndex.get(rootValue);
        int leftTreeLen = inOrderRootIndex - inStart;
        //构造左右子树

        //后序遍历的左子树在数组中起始位置 postStart,结束位置 postStart + leftTreeLen-1
        //中序遍历的左子树在数组中起始位置 inStart,结束位置 inOrderRootIndex-1
        root.left = buildTree(postorder, postStart , postStart + leftTreeLen-1,
                inorder, inStart, inOrderRootIndex - 1);


        //后序遍历的右子树在数组中起始位置 postStart + leftTreeLen ,结束位置 postEnd-1
        //中序遍历的右子树在数组中起始位置 inOrderRootIndex+1,结束位置 inEnd
        root.right = buildTree(postorder, postStart + leftTreeLen , postEnd-1,
                inorder, inOrderRootIndex + 1, inEnd);
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


