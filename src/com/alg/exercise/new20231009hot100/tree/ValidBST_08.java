package com.alg.exercise.new20231009hot100.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * <p>
 * <p>
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 1）中序遍历二叉搜索树 是升序的链表
 *
 * 2）左子树中的最大值 < root < 右子树中的最小值
 *  将最大值和最小值 一直传下去，传入到每个子树的遍历中
 *
 * @author ben.gu
 */
public class ValidBST_08 {


    //中序遍历二叉搜索树 是升序的链表
    private List<TreeNode> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val >= list.get(i + 1).val) {
                return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    // min < n.val < max.value
    private boolean isValid(TreeNode n, TreeNode min, TreeNode max) {
        if (n == null) {
            return true;
        }
        if (min != null && n.val <= min.val) {
            return false;
        }
        if (max != null && n.val >= max.val) {
            return false;
        }
        return isValid(n.left, min, n) && isValid(n.right, n, max);
    }


}
