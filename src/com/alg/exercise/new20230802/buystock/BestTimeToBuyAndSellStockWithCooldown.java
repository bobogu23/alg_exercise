package com.alg.exercise.new20230802.buystock;

/**
 * 买卖股票，含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 给定一个整数数组prices，其中 prices[i] 表示第 i 天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class BestTimeToBuyAndSellStockWithCooldown {


    //买卖次数不限制，但是有冷冻期。
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                //持有股票
                dp[i][1] = -prices[i];
                continue;
            }
            if (i - 1 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                //持有股票
                dp[i][1] = Math.max(dp[i-1][1],- prices[i]);
                //i = 1
                // = Math.max(dp[i-1][1],dp[i-2][0]- prices[i])
                // = Math.max(dp[i-1][1],dp[-1][0] - prices[i])
                // = Math.max(dp[i-1][1],0 - prices[i])
                continue;
            }
            //卖出股票后，需要过一天才能买入，
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[n-1][0];
    }

}
