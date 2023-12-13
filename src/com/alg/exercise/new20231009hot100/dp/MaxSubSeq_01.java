package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 * 最长递增子序列
 * <p>
 * <p>
 * 输入一个无序的整数数组，请你找到其中最长的严格递增子序列的长度，函数签名如下：
 * <p>
 * int lengthOfLIS(int[] nums);
 * 比如说输入nums=[10,9,2,5,3,7,101,18]，其中最长的递增子序列是 [2,3,7,101]，
 * 所以算法的输出应该是 4。
 * <p>
 * <p>
 * 定义dp数组，dp[i] 表示以nums[i]结尾的最长递增子序列的长度。
 * <p>
 * 假设 已知 dp[0~3] 的值，如何求dp[4]的值。
 * 遍历 nums[0] ~ nums[3] ,找到 小于 nums[4]的值，遍历每个小于nums[4]的值 n，
 * 将nums[4]  追加在n后面，即可形成新的递增子序列。
 * 求最长递增子序列，只需要遍历每个小于nums[4]的n，取对应的dp[i] +1 ,取最大的dp[i]
 * +1 ,即可形成nums[i]结尾的最大的递增子序列。
 *
 * @Author: gu
 * @Date: 2023/12/11 上午11:35
 */
public class MaxSubSeq_01 {

    public static void main(String[] args) {
        int[] array ={10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(array);
        System.err.println(res);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);//最差的情况，递增子序列长度为1

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                //遍历每个小于 i 的num[j]
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 1;
        for(int i = 0; i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
