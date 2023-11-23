package com.alg.exercise.new20230811dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列
 * （即位于正下方或者沿对角线向左或者向右的第一个元素）
 * 。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * ========================================================
 * 下个元素 可以是正下方，左下方，右下方，就是状态转移。
 * 从第一行的任何元素开始，就是穷举
 * <p>
 * dp[row][i] 表示已第row行的第i位开始 的路径最小和。
 * 要想使最终的路径和最小，则每下降一次的路径和也要最小。
 * dp[row][i] 先把第一行中每列开始的路径和初始化。
 * <p>
 * 最终取 dp[row-1]这一行的每一列的值的最小值
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 */
public class MinFallingPathSum {

    public static void main(String[] args) {
        // {{2,1,3},{6,5,4},{7,8,9}}
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        MinFallingPathSum m = new MinFallingPathSum();
        System.err.println(m.minFallingPathSum(matrix));

    }

    private int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        memo = new int[row][col];
        int[] dp = new int[col];
        for (int r = 0; r < row; r++) {
            Arrays.fill(memo[r], 20000);
        }
        for (int i = 0; i < col; i++) {
            dp[i] = dp(matrix, row - 1, i);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    private int dp(int[][] matrix, int row, int col) {
        // 不满足条件.dp 给一个超过10000的值
        if (row < 0 || col < 0
                || row > matrix.length - 1 || col > matrix[0].length - 1) {
            return 30000;
        }
        //base case
        if (row == 0) {
            return matrix[0][col];
        }

        //备忘录.matrix 最多100行，每个数字最大100.
        if (memo[row][col] != 20000) {
            return memo[row][col];
        }
        memo[row][col] = matrix[row][col]+ min(dp(matrix, row - 1, col),
                dp(matrix, row - 1, col + 1),
                dp(matrix, row - 1, col - 1));
        return memo[row][col];

    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
