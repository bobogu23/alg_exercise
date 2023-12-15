package com.alg.exercise.new20231009hot100.dp;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11]
 * <p>
 * 解法：
 * 设 整个数组的所有元素之和为sum,元素个数为n
 * 相当于求n个元素是否能恰好凑成和为sum/2
 * 0-1背包问题
 *
 * 状态 ：数组的前n个数字,数字之和sum
 * 选择：不选或者选择
 *
 * @Author: gu
 * @Date: 2023/12/14 上午11:12
 */
public class CanPartition_18 {
    public static void main(String[] args) {
        CanPartition_18 cp =new CanPartition_18();
        int[] a ={1,2,3,5};
        boolean res = cp.canPartition(a);
        System.err.println(res);

    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[n+1][sum+1];

        //base case,amount=0 能凑成
        for(int i = 0;i<=n;i++){
            dp[i][0] = true;
        }


        //状态1：sum
        for (int i = 1; i <= sum; i++) {
            //状态2：数字，相当于前n个硬币
            for(int j = 1;j <= n;j++){
                //凑不出i，只能不选, 依赖 前j-1个硬币 是否能凑成i的结果
                if(i- nums[j-1] < 0 ){
                    dp[j][i] = dp[j-1][i];
                }else{
                    //选择或者不选
                    dp[j][i] =  dp[j-1][i] //不选择
                            || dp[j-1][i-nums[j-1]]; //选择
                }
            }
        }

        return dp[n][sum];


    }
}
