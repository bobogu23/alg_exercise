package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 * 最小路径和。
 * <p>
 * <p>
 * 现在给你输入一个二维数组grid，其中的元素都是非负整数，现在你站在左上角
 * ，只能向右或者向下移动，需要到达右下角。现在请你计算，经过的路径和最小是多少？
 * <p>
 * <p>
 * 动态规划：
 * 状态：二位数组的横坐标，纵坐标。
 * <p>
 * 选择：向下或者向右。
 * <p>
 * dp[i][j]:从 [0,0] 到[i,j]的最小路径和。
 *
 * @Author: gu
 * @Date: 2023/12/12 下午10:36
 */

public class MinPathSum_08 {

    public static void main(String[] args) {
        MinPathSum_08 mps = new MinPathSum_08();
        int[][] a ={{1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int i = mps.minPathSum(a);
        System.err.println(i);
        i = mps.minPathSum2(a);
        System.err.println(i);

    }

    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        //初始化备忘录
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }

        return dp(grid, grid.length - 1, grid[0].length - 1);
    }

    private int[][] memo;

    private int dp(int[][] grid, int i, int j) {
        //base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        //
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        //备忘录
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //尝试向下，或者向右
        memo[i][j] = Math.min(
                dp(grid, i - 1, j),
                dp(grid, i, j - 1)
        ) + grid[i][j];
        return memo[i][j];

    }

    private int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //初始化第一行，第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(
                        dp[i-1][j],
                        dp[i][j-1]
                ) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }


}
