package com.alg.exercise.new20230811dp;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 0-1背包问题。
 * dp[i][j] 表示装前i+1个物品，是否刚好能装满容量j。
 * 如果不装第i+1个物品，背包是否能装满 取决于 dp[i-1][j]
 * 如果装第i+1个物品，背包是否能装满 取决于 dp[i-1][j-nums[i-1]]
 * <p>
 * nums表示每个物品的重量
 *
 * @author ben.gu
 */
public class CanPartition {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        CanPartition p = new CanPartition();
        System.err.println(p.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum; j++) {
                //边界情况
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
                }
            }
        }
        return dp[len][sum];
    }


}
