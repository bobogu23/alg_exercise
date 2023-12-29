package com.alg.exercise.new20231215hot100.repeat;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数
 *
 * @Author: gu
 * @Date: 2023/12/27 下午12:49
 */
public class NumSquares {

    //凑硬币，硬币 1，4，9，16， 数量不限制，求凑成金额n的最小硬币数。
    //dp[n-1] + 1 , dp[n-4] + 1, dp[n-9] + 1 ,dp[n-16] +1
    //完全平方数 1, 2*2 ,3*3 ,4*4 ....

    public static void main(String[] args) {
        NumSquares n = new NumSquares();
        int res  = n.numSquares(13);
        System.err.println(res);
    }

    public int numSquares(int n) {
          //和为n的完全平方数： dp[n] = min( "n- 1" 的 完全平方数的最少数量, "n- 4" 的 完全平方数的最少数量
        //, "n- 9" 的 完全平方数的最少数量 ... , "n- 1" 的 完全平方数的最少数量 ) + 1
        int[] dp  = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i =1 ;i<=n;i++){
            for(int j =1 ; j*j <= i;j++){
                //尝试将 n减去  1~i 范围内的完全平方数 得到m, dp[n] = 最小的 （dp[m] + 1）
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];


    }




}
