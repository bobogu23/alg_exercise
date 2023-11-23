package com.alg.exercise.easy;


/**
 * 最大子数组
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * https://leetcode-cn.com/problems/maximum-subarray/solution/xiang-xi-jie-du-dong-tai-gui-hua-de-shi-xian-yi-li/
 * 动态规划，sum[i] = max(sum[i-1]+a[i],a[i])
 * 以前一个位置为结束点的最大子数列、当前位置的值，比较大小
 *
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int []{-2,1,-3,4,-1,2,1,-5,4};
        System.err.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int sum = nums[0];
        int subArrayMaxSum = nums[0];
        for(int i = 1;i < nums.length;i++){
            subArrayMaxSum =  Math.max(subArrayMaxSum + nums[i],nums[i]);//前一个节点为结束节点的最大连续子数组的和
            sum =  Math.max(sum,subArrayMaxSum);
        }
        return sum;

    }
}
