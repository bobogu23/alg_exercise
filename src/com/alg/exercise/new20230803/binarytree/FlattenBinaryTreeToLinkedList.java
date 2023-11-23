package com.alg.exercise.new20230803.binarytree;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(5);

        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);

        TreeNode r3 = new TreeNode(6);

        root.left =l1;
        root.right =r1;

        l1.left=l2;
        l1.right=r2;

        r1.right = r3;

        FlattenBinaryTreeToLinkedList f = new FlattenBinaryTreeToLinkedList();
        f.flatten(root);


    }

    public void flatten(TreeNode root) {
        //递归，将左子树展开成单链表l，放到当前节点的右节点，
        //将右子树展开成单链表，接到l的右节点
        //针对单个节点来说要做的事情是，left=null,right.next= 左子树的单列表,然后再加入右子树的单链表
        if (root == null) {
            return;
        }
        //左右子树拉平
        flatten(root.left);
        flatten(root.right);

        TreeNode l = root.left;
        TreeNode r = root.right;
        //左节点设置成null,左子树接到右节点
        root.left = null;
        root.right= l;

        TreeNode n = root;
        while (n.right != null) {
            n = n.right;
        }
        n.right = r;
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
