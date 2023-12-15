package com.alg.exercise.new20231009hot100.dp;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/?envType=study-plan-v2&envId=top-100-liked
 * 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * <p>
 * 解题：
 * 状态？ nums[..i]结尾的子数组
 * 选择？乘当前位置的数字或者不乘
 * <p>
 * dp[i] 以i结尾，乘积最大的非空连续子数组
 *
 * @Author: gu
 * @Date: 2023/12/14 上午10:41
 */
public class MaxProduct_17 {
    public static void main(String[] args) {
        MaxProduct_17 mp = new MaxProduct_17();
        int[] a = {-1,-2,-9,-6};
        int res = mp.maxProduct(a);
        System.err.println(res);
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] dpmin = new int[n];//加最小的dp数组，负数*负数 可得正数
        //base case
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            dpmin[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            int mintmp = Math.min(dpmin[i - 1] * nums[i], dpmin[i]);
            dpmin[i] = Math.min(mintmp,dp[i-1] * nums[i]);

            int maxtmp = Math.max(dp[i - 1] * nums[i], dp[i]);
            dp[i] = Math.max(maxtmp,dpmin[i - 1] * nums[i]);
        }
        int res = -11;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }


}
