package com.alg.exercise.new20231009hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * 使用前缀和，pre[i] 表示[0~i]范围的数字之和，连续子数组和为K，即 pre[i]-pre[j]= k
 * pre[i] = pre[j]+k,即某个连续子数组之和+k 等于另一个连续子数组之和。
 *
 * @author ben.gu
 */
public class SubarraySumEqualsK_09 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3 ;
        SubarraySumEqualsK_09 s = new SubarraySumEqualsK_09();
        System.err.println(s.subarraySum(nums,k));

    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];//前缀和pre[i]
            if (sumCount.get(sum - k) != null) {//存在前缀和 pre[j],使得 pre[i]-pre[j] = k
                count++;
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
