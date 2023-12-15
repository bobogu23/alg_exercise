package com.alg.exercise.new20231009hot100.dp;

/**
 * 最小路径和。
 * <p>
 * https://leetcode.cn/problems/minimum-path-sum/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 *
 * @Author: gu
 * @Date: 2023/12/14 下午7:15
 */
public class MinPathSum_21 {


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //选择，左边的dp，上边的dp 较小值
                dp[i][j] = Math.min(
                        dp[i][j-1],
                        dp[i-1][j]) + grid[i][j];
            }

        }

        return dp[m-1][n-1];

    }


}
