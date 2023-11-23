package com.alg.exercise.mid.topcode20221107;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/minimum-path-sum/
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinimumPathSum_64 {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.err.println(minPathSum(grid));
        System.err.println(minpath(grid));
    }

    public static int minpath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        memo = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp1(grid, row - 1, col - 1);
    }

    private static int dp1(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = Math.min(dp1(grid, i - 1, j), dp1(grid, i, j - 1)) + grid[i][j];
        return memo[i][j];
    }


    /**
     * 动态规划
     * dp(grid,i,j) = min(dp(grid,i-1,j) , dp(grid,i,j-1)) + grid(i,j)
     *
     * @param grid
     * @return
     */

    private static int[][] memo;

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(grid, m - 1, n - 1);
    }


    private static int dp(int[][] grid, int m, int n) {
        //base case
        if (m == 0 && n == 0) {
            return grid[m][n];
        }
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        memo[m][n] = Math.min(dp(grid, m - 1, n), dp(grid, m, n - 1)) + grid[m][n];
        return memo[m][n];
    }


}
