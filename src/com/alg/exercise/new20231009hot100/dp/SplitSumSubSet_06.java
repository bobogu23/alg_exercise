package com.alg.exercise.new20231009hot100.dp;

/**
 * 分割等和子集
 * 给定一个只包含正整数的非空数组，是否可以将这个数组分割成两个子集，使得子集的元素和相等
 * <p>
 * 解法：
 * 转换成0-1背包问题。先对数组整体求和sum,
 * 相当于求 对于n个物品，能装sum/2重量的背包，每个物品重量为nums[i],
 * 能否恰好装满。
 * <p>
 * 定义dp数组 ，dp[i][j] 对于前i个数字，能否恰好装满j重量的背包。
 *
 * @Author: gu
 * @Date: 2023/12/12 下午12:27
 */
public class SplitSumSubSet_06 {

    public static void main(String[] args) {
        SplitSumSubSet_06 s = new SplitSumSubSet_06();
        int[] n = {1, 2,3,5};
        boolean res = s.canPartition(n);
        System.err.println(res);
    }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //sum 不能整除，不能分割成两个和相等的数组
        if (sum % 2 > 0) {
            return false;
        }
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        //base case.背包重量为0
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }

        sum = sum / 2;


        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                //边界
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //放入或者不放入背包
                    dp[i][j] = dp[i - 1][j]
                            || dp[i - 1][j - nums[i - 1]];
                }

            }
        }
        return dp[len][sum];
    }

}
