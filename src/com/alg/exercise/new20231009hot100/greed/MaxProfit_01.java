package com.alg.exercise.new20231009hot100.greed;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author ben.gu
 */
public class MaxProfit_01 {

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        // [k][2] ,k 表示天数，2有 0，1 两种值 表示 不持有，持有 股票的状态
        int[][] dp = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0][1] = -prices[0];
                dp[0][0] = 0;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //最后一天手上没股票，收益最大
        return dp[len - 1][0];
    }

}
