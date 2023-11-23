package com.alg.exercise.new20230804.bst;

/**
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点
 * ，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 删除二叉搜索树节点有几种情况
 * 1、节点没有子节点，直接删除
 * 2、节点只有一个子节点，跟子节点交换位置，然后删除子节点
 * 3、节点有左右两个子节点。找到右子树的最小节点，替换当前节点。
 */
public class DeleteNodeInABst {


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            //找到右子树的最小节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right,minNode.val);
            //右子树最小节点，替换root
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;

        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;

    }

    private TreeNode getMin(TreeNode treeNode){
        TreeNode n = treeNode;
        while (n.left != null){
            n = n.left;
        }
        return n;
    }

    public class TreeNode {
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
