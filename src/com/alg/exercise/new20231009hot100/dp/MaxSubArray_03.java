package com.alg.exercise.new20231009hot100.dp;

/**
 * 最大子数组和
 * <p>
 * 比如说输入nums = [-3,1,3,-1,2,-4,2]，算法返回 5，因为最大子数组[1,3,-1,2]的和为 5。
 * <p>
 * 子数组是连续的。
 * <p>
 * 定义
 * dp[i]： 以nums[i]结尾的最大子数组和
 *
 * @Author: gu
 * @Date: 2023/12/11 下午8:10
 */
public class MaxSubArray_03 {
    public static void main(String[] args) {
        MaxSubArray_03 ms = new MaxSubArray_03();
        int[] a = {-3,1,3,-1,2,-4,2};
        int res = ms.maxSubArray(a);
        System.err.println(res);
    }


    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        //状态转移
        for (int i = 1; i < n; i++) {
            //判断dp[i-1] + nums[i] ,和 nums[i] 哪个更大
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }


}
