package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 * @Author: gu
 * @Date: 2023/12/25 上午12:01
 */
public class LowestCommonAncestor {

    // 找到末尾是p ，q的节点链表。
    //从链表开头开始寻找，最后一个公共节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root,p.val,q.val);
    }

    // 在二叉树中寻找 v1  和 v1 的最近公共祖先节点
    // 如果 v1,v2 分别在 root的左右子树中，则root就是最近公共节点
    // 如果 v1,v2 都不在 root的左右子树中，则 返回null
    // 如果 v1=root || v2==root ,则root就是最近公共节点.(因为v1,v2一定在二叉树中，如果v1 =root,v2一定在root的子树中)

    TreeNode find(TreeNode root, int v1, int v2) {
        if(root == null){
            return null;
        }
        if(root.val == v1 || root.val == v2){
            return root;
        }
        TreeNode left = find(root.left, v1, v2);
        TreeNode right = find(root.right, v1, v2);
        if(left != null && right != null){
            return root;
        }
       return left != null ? left:right;
    }
}
