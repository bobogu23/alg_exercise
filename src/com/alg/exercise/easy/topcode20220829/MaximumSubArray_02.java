package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/maximum-subarray/
 * <p>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaximumSubArray_02 {

    public static void main(String[] args) {
        int[] nums  = {-2,1,-3,4,-1,2,1,-5,4 };
        System.err.println(maxSubArray(nums));
        int[] nums1  = {-2,1,-3,4,-1,2,1,-5,4};
        System.err.println(maxSubArrayv2(nums1));
    }



    public static int maxSubArray(int[] nums) {
        //1.动态规划。
        //下标从0 ~ n-1,遍历数组，求下标i结尾的 连续子数组的最大和 f(i)
        // 。如果如果f(i-1) >0,则f(i) =f(i-1)+nums[i],并且将结果放在nums[i],否则nums[i]的元素不动。
        // 最后遍历一次数组，取最大元素

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static int maxSubArrayv2(int[] nums) {
        //1.贪心算法。
        //遍历数组，当前元素之前的n个元素之和sum小于0，则丢弃。否则 sum = sum+当前元素，n个元素的最大和 max= Max(sum,max)

        int curSum = nums[0] ,maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = curSum < 0 ? nums[i] :curSum + nums[i];
            maxSum = Math.max(curSum ,maxSum);
        }

        return maxSum;
    }
}
