package com.alg.exercise.new20231215hot100.repeat;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @Author: gu
 * @Date: 2023/12/27 下午12:09
 */
public class ClimbStair {

    //动态规划。
    //状态 ： 到 i 阶的爬楼梯方法。
    //选择：爬1个，2个台阶
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            //爬到i阶的方法数 = 爬到 i-1 + 爬到 i-2 阶的方法数
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

}
