package com.alg.exercise.mid;

import java.util.*;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 使用递归,从根节点开始深度遍历，记录每个节点的父节点。
 * 从p节点开始,往上取父节点,记录访问过的节点，一直到没有父节点为止。
 * 从q节点开始,往上取父节点,判断父节点是否存在于p刚才访问过的父节点中，碰到的第一个公共父节点则为
 * 最近公共祖先
 *
 */
public class BinaryTreeLowestCommonAncestor {
    private Map<TreeNode,TreeNode> parentNodes = new HashMap<>();


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        List<TreeNode> visited = new ArrayList<>();
        while (p != null){
            visited.add(p);
            p = parentNodes.get(p);
        }
        while (q != null){
            if(visited.contains(q)){
                return q;
            }
            q = parentNodes.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            parentNodes.put(root.left,root);
            dfs(root.left);
        }
        if(root.right != null){
            parentNodes.put(root.right,root);
            dfs(root.right);
        }
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

        TreeNode(int val,   TreeNode left,   TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
