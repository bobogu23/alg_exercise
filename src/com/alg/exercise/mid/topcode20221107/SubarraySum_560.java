package com.alg.exercise.mid.topcode20221107;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/?favorite=2cktkvj
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 */
public class SubarraySum_560 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        SubarraySum_560 s = new SubarraySum_560();
        System.err.println(s.subarray(a, 1));
    }


    /**
     * 1,2,3
     * 前缀和1,3,6
     * 1-0=1
     * 3-1=2
     * 6-3=3
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarray(int[] nums ,int k){
        if(nums.length ==0){
            return 0;
        }
        int count = 0;
        int presum =0 ;
        Map<Integer,Integer> sumCount = new HashMap<>();
        sumCount.put(0,1);
        for(int n:nums){
            presum+=n;
            if(sumCount.containsKey(presum-k)){
                count +=sumCount.get(presum-k);
            }
            sumCount.put(presum,sumCount.getOrDefault(presum,0)+1);
        }
        return count;

    }
    /**
     * 前缀和+hashmap
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        //key前缀和，value:前缀和次数
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int presum = 0;
        for(int n:nums){
            presum += n;
            //存在  presum-k 说明 存在区间（也就是子数组）的和=k,
            if(map.containsKey(presum-k)){
                count +=map.get(presum-k);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }


}
