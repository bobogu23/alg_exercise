package com.alg.exercise.new20231215hot100.repeat;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @Author: gu
 * @Date: 2023/12/27 下午7:23
 */
public class PartitionEqualSubsetSum {


    //相当于求 nums中的数字是否可以相加 = nums 的数字总和/2
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 > 0) {
            return false;
        }
        sum = sum/2;
        int len = nums.length;
        boolean[][] dp = new boolean[sum+1][len+1];

        //base case . amount =0 ,能凑成
        for(int i =0 ; i<=len;i++){
            dp[0][i] = true;
        }

        //状态：amount
        for(int i = 1; i<= sum ;i++){
            //状态：数字，可以选择或者不选择
            for(int j = 1;j<=len;j++){
                //nums[j] 当前数字 > i,不能选择，
                if(nums[j] > i){
                    dp[i][j]= dp[i][j-1];
                }else {
                    // 可以选择当前数字，或者不选当前数字
                    //如果选择了当前数字，状态依赖于 dp[i-nums[j][
                    dp[i][j] = dp[i][j-1] || dp[i-nums[j-1]][j-1];
                }
            }
        }

        return dp[sum][len];


    }





}
