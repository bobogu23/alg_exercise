package com.alg.exercise.new20230802.buystock;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 */
public class BestTimeToBuyAndSellStock3 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        BestTimeToBuyAndSellStock3 s = new BestTimeToBuyAndSellStock3();
        System.err.println(s.maxProfit(prices));
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k =2; //最多k笔交易，k的范围 0~k
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for(int j = k;j>=1;j--){
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                //第i天不持有股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //第i天持有股票,
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j-1][0] - prices[i]);
            }


        }

        //最后一天手上没股票，利润最大
        return dp[n - 1][k][0];
    }

}
