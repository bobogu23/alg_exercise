package com.alg.exercise.new20231009hot100.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * ****** preorder 和 inorder 均 无重复 元素 *****
 * preorder中第一个数字是 root, inorder 中 root左边是左子树，右边是右子树。
 * <p>
 * 如何知道root在inorder数组中的位置？一个个遍历？可以用map。
 * <p>
 * 找到root在inorder中的位置，就能知道左子树范围，右子树的范围
 *
 * @author ben.gu
 */
public class BuildTree_12 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree_12 bt = new BuildTree_12();
        TreeNode treeNode = bt.buildTree(preorder, inorder);
        System.err.println(treeNode);
    }


    private Map<Integer, Integer> inorderPosition = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderPosition.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if(pstart > pend){
            return null;
        }
        TreeNode root = new TreeNode();
        int rootValue = preorder[pstart];
        root.val = rootValue;

        int rootInorderPosition = inorderPosition.get(rootValue);

        root.left = buildTree(preorder, pstart + 1, pstart + rootInorderPosition - istart,
                inorder, istart, rootInorderPosition - 1);


        root.right = buildTree(preorder, pstart + rootInorderPosition - istart + 1, pend,
                inorder, rootInorderPosition + 1, iend);

        return root;
    }
}
