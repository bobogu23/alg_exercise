package com.alg.exercise.new20230802.buystock;

/**
 *https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 */
public class BestTimeToBuyAndSellStock4 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k =2;
        BestTimeToBuyAndSellStock4 s = new BestTimeToBuyAndSellStock4();
        System.err.println(s.maxProfit(k,prices));
    }


    public int maxProfitNoLimit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            //第i天不持有股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //第i天持有股票,
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        //最后一天手上没股票，利润最大
        return dp[n - 1][0];
    }

    public int maxProfit(int k , int[] prices) {
        int n = prices.length;
        //最多k笔交易，k的范围 0~k. 当天买，当天卖 没有利润，所以 如果k > n/2 说明没有 交易次数限制，
        // 按照没有交易次数限制的方式处理
        if(k > n/2 ){
            return maxProfitNoLimit(prices);
        }

        int[][][] dp = new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for(int j = k;j >= 1;j--){
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                //第i天不持有股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //第i天持有股票, max(前一天持有股票，到前一天为止交易次数为j，  前一天手上没有股票，当前买入了股票，到前一天为止的交易次数为j-1)
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j-1][0] - prices[i]);
            }
        }

        //最后一天手上没股票，利润最大
        return dp[n - 1][k][0];
    }

}
