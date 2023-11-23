package com.alg.exercise.new20230808hot100;

/**
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
 * ，并返回其长度。如果不存在符合条件的子数组，返回 0
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 解法1：前缀和+二分查找(因为是正整数，所以前缀和是递增的，可以用二分查找)
 * 解法2：双指针
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
        int[] a = {2, 3, 1, 2, 4, 3};
        int res = m.minSubArrayLen(7, a);
        System.err.println(res);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0, fast = 0;
        int len = nums.length;
        int res = Integer.MAX_VALUE;

        int sum = 0;
        while (fast < len) {
            sum += nums[fast];
            while (sum >= target) {
                res = Math.min(res, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
