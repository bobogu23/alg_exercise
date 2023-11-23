package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/binary-search/?plan=leetcode_75&plan_progress=gb9pjkv
 * 给定一个n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * [-1,0,3,5,9,12]
 * 9
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.err.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = high - (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
             } else {
                low = mid + 1;
             }
        }
        return -1;
    }

}
