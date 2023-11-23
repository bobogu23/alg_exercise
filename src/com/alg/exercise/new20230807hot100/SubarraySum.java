package com.alg.exercise.new20230807hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * <p>
 * 前缀和
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] a ={1,-1,0};
        int k = 0;
        SubarraySum s = new SubarraySum();
        System.err.println(s.subarraySum(a,k));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);

        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //前缀和
            sum = sum + nums[i];
            if (sumCount.get(sum - k) != null) {
                // 要把满足条件次数加上
                res = res+ sumCount.get(sum - k);
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

}
