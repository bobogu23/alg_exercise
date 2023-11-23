package com.alg.exercise.mid.topcode20221107;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?favorite=2cktkvj
 *
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit_309 {

    public static void main(String[] args) {
        int[] a = {1,10,2,8,6,20,3};
        MaxProfit_309 p = new MaxProfit_309();
        System.err.println( p.maxProfit(a));
        System.err.println( p.mp(a));

    }

    public int mp(int[] prices){
        int n=prices.length;
        int[][]dp = new int[n][2];
        for(int i =0 ;i< n;i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = - prices[i];
            }else if( i == 1){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);//不持有股票，i-1持有股票+第i天卖出股票
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
            }else{
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);//不持有股票，i-1持有股票+第i天卖出股票
                dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
            }
        }
        return dp[n-1][0];

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // dp[i][0] 表示第i天不持有股票的最大利润，等于max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] 表示第i天 持有股票的最大利润，等于max(dp[i-1][1],dp[i-2][0]-prices[i])。卖出股票后有冷冻期，
        //所以从 不持有股票->持有股票，间隔2天
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }else if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i-2][0]- prices[i]);
        }
        return dp[n-1][0];//最后一天，手上没股票 才是最大利润
    }
}
