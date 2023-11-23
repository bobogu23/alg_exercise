package com.alg.exercise.new20230802.buystock;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 总利润为 4 。
 * <p>
 * k 表示交易次数，这题的交易次数不限。 k 次数不限，k 和 k-1 可以认为是一样的
 * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k-1][1] + prices[i]);
 * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k-1][0] - prices[i])
 * = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
 * <p>
 * 进一步转换，k不会改变，直接不记录
 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
 */
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        BestTimeToBuyAndSellStock2 s = new BestTimeToBuyAndSellStock2();
        System.err.println(s.maxProfit(prices));
    }


    public int maxProfit(int[] prices) {
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

}
