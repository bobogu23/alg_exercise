package com.alg.exercise.new20231009hot100.tree;

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 递归遍历 节点root的左子树，展开成单链表，做为当前节点的右节点，
 * 遍历节点root的右子树，展开成单链表，做为右节点的最后一个节点的右节点
 * <p>
 * 针对单个节点，展开成单链表要做的事情：
 * l= flat(root.left)
 * r= flat(root.left)
 * root.left=null,
 * root.right=l
 * l.right=r
 *
 * @author ben.gu
 */
public class BinaryTreeFlattern_11 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = null;
        root.right = l;
        TreeNode n = root;
        while (n.right != null) {
            n = n.right;
        }
        n.right= r;
    }


}
