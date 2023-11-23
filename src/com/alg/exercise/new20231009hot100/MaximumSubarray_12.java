package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 前缀和。
 * dp[i] 表示 以nums[i]结尾的最大子数组之和
 * dp[i]= max(dp[i-1]+nums[i],nums[i]).
 *
 * @author ben.gu
 */
public class MaximumSubarray_12 {

    public static void main(String[] args) {
        int[] ar ={-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray_12 m = new MaximumSubarray_12();
        System.err.println(m.maxSubArray(ar));
    }
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
