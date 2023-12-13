package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/?envType=study-plan-v2&envId=top-100-liked
 * 零钱兑换
 * <p>
 * 硬币数量无限
 * <p>
 * 状态 ：金额
 *
 * <p>
 * 选择：硬币
 *
 * @Author: gu
 * @Date: 2023/12/13 下午9:20
 */
public class CoinChange_14 {

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
        CoinChange_14 c = new CoinChange_14();
        int i = c.coinChange(coins, amount);
        System.err.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount +1 ];
        Arrays.fill(memo,-2);
        int res = dp(coins,amount);
        return res;
    }


    private int[] memo;

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1 ;
        }
        //备忘录
        if(memo[amount] != -2){
            return memo[amount];
        }
        //硬币选择
        int num = Integer.MAX_VALUE;
        for(int c:coins){
            int res = dp(coins,amount - c);
            if(res == -1){
                //凑不出硬币
                continue;
            }
            //取最小硬币数
            num = Math.min(num,res+1);
        }
        //放入备忘录
        memo[amount] = num == Integer.MAX_VALUE ? -1 :num;
        return memo[amount];
    }


}
