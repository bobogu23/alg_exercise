package com.alg.exercise.new20230811dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * dp[i]: 以nums[i]结尾的数组中的最长递增子序列长度。
 * <p>
 * <p>
 * dp数组初始化为1
 * dp[i]计算：
 * nums[0~i] 范围内，以某个元素结尾的子数组的 递增子序列最大长度为 dp[j]，如果nums[j] < nums[i] ，则nums[i] 可以加到nums[j] 之后，
 * 形成新的最长子序列，dp[i] = dp[j]+1 , 求 0~i 范围内，这些dp[i]的最大值，做为dp[i]的最终值
 */
public class LongestIncreasingSubSeq {

    public static void main(String[] args) {

    }


    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
