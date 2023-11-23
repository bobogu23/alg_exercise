package com.alg.exercise.mid.topcode20221107;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode.cn/problems/coin-change/?favorite=2cktkvj
 * <p>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 动态规划
 */
public class CoinCharge_322 {
    public static void main(String[] args) {
        CoinCharge_322 c = new CoinCharge_322();
        int[] a = {1};
        int amount = 0;

        int count = c.coinChange(a, amount);
        System.err.println(count);

    }


    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-2);
        return dp(coins, amount);
    }

    // f(amount) = f(amount-coin) +1,amount随着硬币面额变化
    //备忘录
    int[] memo;

    public int dp(int[] coins, int amount) {
        //终止条件
        if (amount == 0) {
            return 0;
        }
        //减去指定面额的硬币后，剩余金额小于0
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        //遍历所有面额的硬币
        for (int coin : coins) {
            //子问题，金额-硬币面额，计算最少硬币个数
            int count = dp(coins, amount - coin);
            //子问题无解
            if (count == -1) {
                continue;
            }
            res = Math.min(res, count + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }


}
