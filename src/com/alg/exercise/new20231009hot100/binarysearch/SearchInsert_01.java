package com.alg.exercise.new20231009hot100.binarysearch;

/**
 * https://leetcode.cn/problems/search-insert-position/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 不存在的情况，记录最终的 left，right
 *
 * @author ben.gu
 */
public class SearchInsert_01 {
    public static void main(String[] args) {
        int[] nums ={1,3,5,6};
        SearchInsert_01 s =  new SearchInsert_01();
        int i = s.searchInsert(nums, 0);
        System.err.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left +  (right - left ) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= len) {
            return len;
        } else if (right < 0) {
            return 0;
        } else {
            return right + 1;
        }
    }

}
