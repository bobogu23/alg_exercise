package com.alg.exercise.new20231215hot100.repeat;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 *
 * @Author: gu
 * @Date: 2023/12/27 下午1:34
 */
public class CoinCharge {

    public static void main(String[] args) {
        int[] coins ={2};
        int amount =3;
        CoinCharge c = new CoinCharge();
        int res = c.coinChange(coins,amount);
        System.err.println(res);

    }

    //状态 amout
    //选择:选硬币或者不选
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0 ;

        //金额
        for (int i = 1; i <= amount; i++) {
            //硬币
            for (int j = 0; j < coins.length; j++) {
                //选择硬币，不选硬币的最小值
                if (coins[j] <= i && dp[i - coins[j]] < dp[i]) {

                    dp[i] = dp[i - coins[j]] + 1;
                }

            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
         if(coins.length == 0 ){
             return -1;
         }
         memo = new int[amount+1];
         memo[0] = 0;
         int res = dp(coins,amount);
         return res;
    }


    //dp[amount] = min (dp[amount-coin]+1)
    int[] memo;

    private int dp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != -1) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;
        //试一下 选择每一种硬币，凑出总金额amount的最少硬币个数
        for(int i = 0 ;i <coins.length;i++){
             int res = dp(coins,amount-coins[i]);
             if(res >= 0  && res < min){
               min = res;
             }
        }

        memo[amount] =  min == Integer.MAX_VALUE ? -1 :min;
        return memo[amount];
    }


}
