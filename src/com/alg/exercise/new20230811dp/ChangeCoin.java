package com.alg.exercise.new20230811dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * ******
 * 会变化的是amount ,也就是状态。
 * <p>
 * basecase,amount ==0,amount <0 .
 * <p>
 * dp[amount] ：组成金额amount 需要的最少硬币数
 */
public class ChangeCoin {

    public static void main(String[] args) {

    }


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);//初始化默认值
        return dp(memo,coins,amount);
    }

    private int dp(int[] memo, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        //剪枝
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dp(memo, coins, amount - coin);
            //没组装成功
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub+1);//sub+1,子结果是amount-coin 需要的金币个数，amount需要再加一个金币
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }


}
