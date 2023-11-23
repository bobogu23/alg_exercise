package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?plan=leetcode_75&plan_progress=gb9pjkv
 * 买卖股票的最佳时机
 */
public class MaxProfit {


    //思路1
    //第一天买入，第2,3,4,5 天卖出的最大利润
    //第二天买入，第3，4，5 天卖出的最大利润
    //第n天买入，利润0
    //利润最小为0,用一个变量存放最大利润


    //思路2.动态规划
    //第i天卖出的最大利润，等于i天的价格- 前i天中的最低价格 或者 等于 前i-1天中的最低价格和i天价格 中的最小值
    //dp[i] = min(dp[i-1],prices[i])  dp[0] = prices[0]
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i-1],prices[i]);
            max = Math.max(max,prices[i]-dp[i]);
        }
        return max;
    }

}
