package com.alg.exercise.mid.topcode20221107;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/?favorite=2cktkvj
 * <p>
 * 给你一个整数数组 nums ，找到其中最长 严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LengthOfLIS_300 {

    public static void main(String[] args) {
        int[] nums = {0,3,1,6,2,2,7};
        System.err.println(lengthOfLIS(nums));

    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];//dp[i]表示以num[i] 这个数结尾的最长递增子序列的长度
        Arrays.fill(dp, 1);//初始化dp,子序列长度最小为1
        for (int i = 0; i < nums.length; i++) {
            //遍历0~i之间的数组，找出比num[i]这个数小的元素,对应位置m，得到dp[m]
            //dp[i] = dp[m]+1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;

    }





}
