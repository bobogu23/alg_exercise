package com.alg.exercise.new20230804.construct.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 拆解。构造root节点，然后构造左，右 子节点
 */
public class ConstructTreeFromProInOrder {


    public static void main(String[] args) {

    }

    private Map<Integer, Integer> inorderNodeIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderNodeIndex.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);

    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        //找到根节点，
        TreeNode root = new TreeNode(rootValue);
        // 中序遍历，root节点的位置
        int inOrderRootIndex = inorderNodeIndex.get(rootValue);
        int leftTreeLen = inOrderRootIndex - inStart;
        //构造左右子树

        //前序遍历的左子树在数组中起始位置 preStart+1,结束位置 preStart + leftTreeLen
        //中序遍历的左子树在数组中起始位置 inStart,结束位置 inOrderRootIndex-1
        root.left = buildTree(preorder, preStart + 1, preStart + leftTreeLen,
                inorder, inStart, inOrderRootIndex - 1);


        //前序遍历的右子树在数组中起始位置 preStart + leftTreeLen+1,结束位置 preEnd
        //中序遍历的右子树在数组中起始位置 inOrderRootIndex+1,结束位置 inEnd
        root.right = buildTree(preorder, preStart + leftTreeLen + 1, preEnd,
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


