package com.alg.exercise.new20230811dp;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 动态规划，dp[i]是以 nums[i]结尾的最大连续子数组。
 * dp[i]算出来后，遍历一遍取最大的
 *
 * @author ben.gu
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            res =  Math.max(res,dp[i]);
        }
        return res;

    }
}
