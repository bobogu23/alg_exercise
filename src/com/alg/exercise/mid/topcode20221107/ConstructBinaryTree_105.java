package com.alg.exercise.mid.topcode20221107;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?favorite=2cktkvj
 */
public class ConstructBinaryTree_105 {
    public static void main(String[] args) {
        ConstructBinaryTree_105 b = new ConstructBinaryTree_105();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = b.buildTree(preorder, inorder);

    }

    /**
     * 前序遍历的第一个节点是根节点
     * <p>
     * 中序遍历，根节点的左边是左子树，右边是右子树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderNodeIndex.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);

    }

    private Map<Integer, Integer> inOrderNodeIndex = new HashMap<>();

    public TreeNode build(int[] preorder,
                          int preStart, int preEnd,
                          int[] inorder,
                          int inStart, int inEnd
    ) {
        if (preStart > preEnd) {
            return null;
        }
        //根节点
        int rootVal = preorder[preStart];
        int inOrderRootIndex = inOrderNodeIndex.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftLen = inOrderRootIndex - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftLen,
                inorder, inStart, inOrderRootIndex - 1);
        root.right = build(preorder, preStart + leftLen + 1, preEnd,
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
