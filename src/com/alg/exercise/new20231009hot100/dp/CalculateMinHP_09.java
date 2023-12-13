package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 * 魔塔游戏
 * <p>
 * 入一个存储着整数的二维数组grid，如果grid[i][j] > 0，说明这个格子装着血瓶，经过它可以增加对应的生命值；
 * 如果grid[i][j] == 0，则这是一个空格子，经过它不会发生任何事情；如果grid[i][j] < 0，说明这个格子有怪物，
 * 经过它会损失对应的生命值。
 * <p>
 * 现在你是一名骑士，将会出现在最上角，公主被困在最右下角，你只能向右和向下移动，请问骑士的初始生命值至少为多少，
 * 才能成功救出公主？
 * <p>
 * <p>
 * 换句话说，就是问你至少需要多少初始生命值，能够让骑士从最左上角移动到最右下角，且任何时候生命值都要大于 0。
 *
 * @Author: gu
 * @Date: 2023/12/12 下午11:20
 */
public class CalculateMinHP_09 {

    public static void main(String[] args) {


    }


    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }
        return dp(grid, 0, 0);
    }

    private int[][] memo;

    //从位置 i,j 开始到最右下角 需要多少初始生命值。
    private int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        //达到最右下角
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] > 0 ? 1 : -grid[i][j] + 1;
        }
        //到达边界的情况
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        //i，j 依赖于 i+1,j   i,j+1 的最小值
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Math.min(
                dp(grid, i + 1, j),
                dp(grid, i, j + 1)
        ) - grid[i][j]; //需要减去 grid[i][j] 上的生命值
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }


}
