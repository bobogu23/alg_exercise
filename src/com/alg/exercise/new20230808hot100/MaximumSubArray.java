package com.alg.exercise.new20230808hot100;

/**
 * https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 动态规划，
 * 以nums[i] 结尾的最大子数组和为 dp[i],
 * dp[i]= max(dp[i-1]+nums[i],nums[i])
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] a ={5,4,-1,7,8};
        MaximumSubArray m = new MaximumSubArray();
        System.err.println(m.maxSubArray(a));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for(int j =0 ; j< dp.length;j++){
            res = Math.max(res,dp[j]);
        }
        return res;
    }

}
