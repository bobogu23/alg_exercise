package com.alg.exercise.new20230612.pd;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/gaM7Ch/
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的
 */
public class MinCoin_03 {
    private int[] memo;


    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins,amount);
    }

    private int dp(int[] coins, int amount) {
        //终止条件
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int num = dp(coins, amount - coin);
            if (num == -1) {
                continue;
            }
            res = Math.min(res, num + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];

    }
}
