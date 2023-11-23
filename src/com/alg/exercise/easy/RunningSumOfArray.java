package com.alg.exercise.easy;

/**
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 * 一维数组动态和
 */
public class RunningSumOfArray {
    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};
        runningSum(nums);
        print(nums);

    }

    //定义变量sum,依次与数组中的每个元素相加，替换数组中的元素
    public static  int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        for(int index = 1 ;index < nums.length; index ++){
            nums[index] = nums[index-1] + nums[index];
        }
        return nums;

    }

    private static void print(int[] nums){
        for(int index = 0 ;index < nums.length; index ++){
            System.err.println( nums[index]);
        }
    }

}
