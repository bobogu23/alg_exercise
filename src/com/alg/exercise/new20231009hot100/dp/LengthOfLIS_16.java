package com.alg.exercise.new20231009hot100.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * https://leetcode.cn/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=top-100-liked
 *
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 解法：
 * 状态：数组的子序列，从索引0开始
 * 选择：追加到 比当前元素小的元素构成的最长递增子序列之后
 *
 * dp[i],以i结尾的最长递增子序列长度
 *
 *
 * @Author: gu
 * @Date: 2023/12/14 上午10:19
 */
public class LengthOfLIS_16 {

    public static void main(String[] args) {
        int[] nums ={1,3,6,7,9,4,10,5,6};
        LengthOfLIS_16 l = new LengthOfLIS_16();
        int i = l.lengthOfLis(nums);
        System.err.println(i);
    }

    public int lengthOfLis(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //初始化
        Arrays.fill(dp,1);

        for(int i =1 ;i < n;i++){
            for(int j = 0;j<i;j++){
                //nums[i] 追加到比它小的 nums[j]后面，构成最长递增最长递增子序列
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //dp数组中的最后一个并不是最大的，需要遍历一次，取最大的
        int res = 1;
        for(int i =0;i<n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }


}
