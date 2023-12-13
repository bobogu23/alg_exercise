package com.alg.exercise.new20231009hot100.dp;

/**
 * https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * 动态规划：
 * 状态 ：台阶数
 * 选择： 爬1个或者2个台阶。
 * <p>
 * 定义dp数组，dp[n],爬n个台阶的方法
 *
 * @Author: gu
 * @Date: 2023/12/13 上午11:03
 */
public class ClimbStrais_10 {
    public static void main(String[] args) {
        int n = 3;
        ClimbStrais_10 cs = new ClimbStrais_10();
        int i = cs.climbStairs(n);
        System.err.println(i);
        System.err.println(cs.climbStairs2(n));
    }


    public int climbStairs2(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp  = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        //状态
        for(int i = 3 ;i <= n; i++){
            //选择
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }


    public int climbStairs(int n) {
         memo = new int[n+1];
         return dp(n);
    }

    private  int[] memo;
    private int dp(int n){
        if(n <= 2){
            return n;
        }


        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = dp(n-1) + dp(n-2);
        return memo[n];
    }

}
