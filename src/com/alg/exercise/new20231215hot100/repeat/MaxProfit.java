package com.alg.exercise.new20231215hot100.repeat;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 *
 * @Author: gu
 * @Date: 2023/12/26 下午12:54
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        //动态规划。
        //状态 第i个元素,
        // 买，卖，不动
        int len = prices.length;
        //第i天,买||卖的 最大利润 , 状态：0 买，1 卖
        int[][] dp = new int[len][2];

        for (int i = 0; i < len; i++) {
            if(i == 0){
                dp[i][1] = -prices[i];//买了股票
                dp[i][0] = 0;//卖，没有股票没法卖，利润 0
                continue;
            }
            //0:不持有股票，可能是之前就没持有股票，或者之前持有了股票 然后卖掉了
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //持有股票.可能是之前持有了，当天休息。或者之前没动，当前持有了
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[len-1][0];


    }


}
