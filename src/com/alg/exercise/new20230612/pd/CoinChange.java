package com.alg.exercise.new20230612.pd;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 * 解题：
 * 1.备忘录，降低时间复杂度
 * 2.状态转移，状态：金额
 *
 */
public class CoinChange {

    int[] memo ;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-2);
        return dp(coins,amount);
    }

    public int dp(int[] coins,int amount){
        //终止条件
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }

        if(memo[amount] != -2){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        //遍历提供的硬币
        for(int coin:coins){
            // 计算子问题：amount-coin
            int count = dp(coins,amount-coin);
            //子问题无解
            if(count == -1){
                continue;
            }
            res= Math.min(res,count+1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1:res;
        return memo[amount];
    }


}
