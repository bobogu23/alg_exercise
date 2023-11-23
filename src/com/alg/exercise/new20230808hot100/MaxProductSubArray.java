package com.alg.exercise.new20230808hot100;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个 32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 *
 *
 * 乘积不能简单的用dp[i-1] * nums[i],nums[i] 计算。
 * 1 ，-6，-3  。dp[2]= 18
 *
 * 乘积最大可能是 正数的最大值 * 正数，可能是 负数*负数
 *
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];//存放i结尾的连续子数组的最小值
        int[] dp2 = new int[nums.length];//存放i结尾的连续子数组的最大值
        dp[0] = nums[0];
        dp2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = min(dp[i - 1] * nums[i], dp2[i - 1] * nums[i] ,nums[i]);
            dp2[i] = max(dp[i - 1] * nums[i], dp2[i - 1] * nums[i] ,nums[i]);
        }
        int res =Integer.MIN_VALUE;
        for (int i = 0; i < dp2.length; i++) {
            res = Math.max(res, dp2[i]);
        }
        return res;
    }

    private int min(int a, int b,int c){
        return Math.min(a, Math.min(b,c));
    }
    private int max(int a, int b,int c){
        return Math.max(a, Math.max(b,c));
    }
}
