package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * 最大利润，只能交易一次。
 *
 */
public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 表示第i天不持有股票的最大利润，等于max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] 表示第i天 持有股票的最大利润，等于max(dp[i-1][1],dp[i-1][0]-prices[i])
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[n-1][0];//最后一天，手上没股票 才是最大利润
    }
}
