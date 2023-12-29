package com.alg.exercise.new20231215hot100.repeat;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有
 * 相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 * @Author: gu
 * @Date: 2023/12/27 下午12:21
 */
public class Rob {

    public static void main(String[] args) {
        int[] a ={2,7,9,3,1};
        Rob r = new Rob();
        int res = r.rob(a);
        System.err.println(res);

    }

    //动态规划，
    //状态：第i个房间
    //选择:偷，不偷
    //dp数组 dp[i][0] ,dp[i][1] 到i个房间为止,不偷or偷了 ，能够偷到的最高金额

    public int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
         for(int i = 0;i <len;i++){
             if(i == 0){
                 //0 不偷，1：偷
                 dp[i][0] = 0;
                 dp[i][1] = nums[i];
                 continue;
             }
             if(i ==1){
                 //0 不偷
                 dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
                 //偷 ，i-1 不能偷
                 dp[i][1] = nums[i];
                 continue;
             }
             //不偷，i-1偷了或者i-1不偷
             dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
             //偷， i-1 不偷， i-2 偷了
             dp[i][1] = Math.max(dp[i-2][1],dp[i-1][0])+nums[i];
         }
         return Math.max(dp[len-1][1],dp[len-1][0]);

    }
}
