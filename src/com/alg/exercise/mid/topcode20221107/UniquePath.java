package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/unique-paths/?favorite=2cktkvj
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 */
public class UniquePath {

    public static void main(String[] args) {
        int m =3,n =3;
        System.err.println(uniquePaths(m,n));;
    }

    static int[][] memo;

    public static int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return dp(m - 1, n - 1);
    }

    private static int dp(int x, int y) {
        //base case
        if (x == 0 || y == 0) {
            return 1;
        }
        if (x <= 0 || y < 0) {
            return 0;
        }
        //备忘录，避免冗余计算
        if (memo[x][y] > 0) {
            return memo[x][y];
        }
        //状态转移方程
        memo[x][y] = dp(x-1,y)+dp(x,y-1);
        return memo[x][y];

    }
}
