package com.alg.exercise.new20231215hot100.repeat;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 *输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * @Author: gu
 * @Date: 2023/12/27 下午6:30
 */
public class LongestIncreasingSubSeq {



    // dp[i] nums[...i] 的最长递增子序列长度
    // 在 0..i-1中 找到 每个 小于 nums[i] 的元素的索引 j, 取dp[j]的最大值，然后+1 就是dp[i]
    public int longest(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        //base case,最长递增子序列最少是1
        Arrays.fill(dp,1);

        for(int i = 1 ;i < len;i++ ){
            for(int j =0 ;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]) + 1;
                }
            }
        }
        int max = 1;
        for(int i = 0 ;i<len;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }

}
