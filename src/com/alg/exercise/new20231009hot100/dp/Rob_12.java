package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋
 * 装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 解题：
 * 可以参考 买卖股票的动态规划,相当于买卖股票有冷冻期。而且这里只有买或者卖，一种状态.
 *
 * 状态：n，表示房屋的索引
 *
 * 选择：偷或者不偷.
 *
 * 不偷 去下一家。偷，去下下一家。
 *
 * base case: 过了最后一家，没得偷了，金额为0
 *
 * @Author: gu
 * @Date: 2023/12/13 下午12:22
 */
public class Rob_12 {

    public int rob(int[] nums) {
        int n = nums.length;
         memo = new int[n];
        Arrays.fill(memo,-1);
        int  res =  dp(nums,0);//从第一家开始偷
        return res;
    }

    private int[] memo ;


    // 从i 开始 能偷的最大金额
    private int dp(int[] nums,int i ){
        if(i >= nums.length){
            return 0;
        }
        //备忘录
        if(memo[i] != -1){
            return memo[i];
        }
        //偷，或者不偷
        int res = Math.max(
                dp(nums,i+1) ,//不偷
                nums[i] + dp(nums,i+2) //偷，那么下一家不能偷了
        );
        memo[i] =  res;
        return memo[i];
    }



}
