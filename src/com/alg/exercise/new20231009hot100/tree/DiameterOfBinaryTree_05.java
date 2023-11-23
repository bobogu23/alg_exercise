package com.alg.exercise.new20231009hot100.tree;

/**
 * https://leetcode.cn/problems/diameter-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 * <p>
 * 深度优先遍历。
 * 定义全局变量 res,表示 两个节点之间的最长路径的长度。
 * <p>
 * 定义函数 dfs,函数传入当前节点n，返回以该节点为根时，方向 往下 的最大路径节点数量（不是边数）
 * 递归处理当前节点n的左右节点，得到左右节点为根时 往下 的最大路径节点数 l,r 。
 * l,r 中较大值+1 就是 函数的返回值。
 * l+r 表示 以当前节点n为路径最高点时的路径长度，更新全局变量 res。
 * 必须在递归的同时 进行最长路径的更新，因为最长路径可能不经过根节点。
 * <p>
 * n
 * 1    3
 * 2       4
 * 0
 * l = 3, r= 2 （l表示左子树最大路径节点数，r表示右子树最大路径节点数）
 * l+r 刚好等于 n做为路径最高点的节点时，这颗二叉树的直径。
 *
 * @author ben.gu
 */
public class DiameterOfBinaryTree_05 {

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int res = 0;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(res, l + r);
        return Math.max(l, r) + 1;
    }

}
