package com.alg.exercise.mid.topcode20221107;

import com.sun.javafx.scene.text.HitInfo;

/**
 * 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees/?favorite=2cktkvj
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class UniqueBinarySearchTree_96 {


    public static void main(String[] args) {

        int n = 2;
        UniqueBinarySearchTree_96 m = new UniqueBinarySearchTree_96();
        System.err.println(m.numTrees(n));
    }


    // bst 遍历，从1到n，每个值都可以做为根节点
    //使用备忘录避免重复计算
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);

    }



    private int count(int lo, int hi) {
        //终止条件
        if (lo > hi) {
            return 1;
        }

        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }
        //每个值都可以做为根节点
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            //左子树二叉搜索树的个数
            int left = count(lo, i - 1);
            //右子树二叉搜索树的个数
            int right = count(i + 1, hi);
            res += left * right;
        }
        memo[lo][hi] = res;
        return res;
    }


}
