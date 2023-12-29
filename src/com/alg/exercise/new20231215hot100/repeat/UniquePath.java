package com.alg.exercise.new20231215hot100.repeat;

/**
 * 一个机器人位于一个 m x n 网格的左上角
 * （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。
 * 机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 *
 * @Author: gu
 * @Date: 2023/12/28 下午7:59
 */
public class UniquePath {

    //假设到了左下角  ，路径数 = start ~ [m,n-1] 路径数+ start~[m-1][n]

    //第一行中，到每个格子的路径数 = 1
    //第一列中，到每个格子的路径数 = 1
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //base case,
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //从 1 * 1的格子开始计算路径数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }

        }
        return dp[m-1][n-1];

    }

}
