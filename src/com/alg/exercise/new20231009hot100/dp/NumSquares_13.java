package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 *
 * https://leetcode.cn/problems/perfect-squares/?envType=study-plan-v2&envId=top-100-liked
 *
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * n的平方数最小数量，可以根据和 为 n- 1*1, n - 2*2, n- 3*3 的平方的最小数量推导出来。
 *
 * dp[i] 表示和为 i 的完全平方数的最少数量
 *
 *
 * @Author: gu
 * @Date: 2023/12/13 下午8:52
 */
public class NumSquares_13 {


    public int numSquares(int n) {
        int[] dp = new int[n+1];
        //初始化成最大的整数，避免求较小值的时候，出现问题
        Arrays.fill(dp, Integer.MAX_VALUE);
        //base case
        dp[0] = 0;

        //状态
        for(int i  = 1; i <= n ;i++){
            //相当于硬币
            for(int j = 1 ; j*j <= i ;j++){
                dp[i] = Math.min(
                        dp[i],
                        dp[i-j*j]+1
                );
            }
        }

        return dp[n];

    }


}
