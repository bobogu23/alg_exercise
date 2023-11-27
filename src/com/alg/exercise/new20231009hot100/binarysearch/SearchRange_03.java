package com.alg.exercise.new20231009hot100.binarysearch;

import com.alg.exercise.utils.CollectionPrintUtils;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * 两次二分查找。
 * 第一次，找到target 后，right = mid-1，继续查找，更新target的位置
 * 第二次，找到target后，left = mid+1，继续查找，更新target的位置
 *
 * @author ben.gu
 */
public class SearchRange_03 {
    public static void main(String[] args) {
        SearchRange_03 sr = new SearchRange_03();
        int[] array = {};
        int[] res = sr.searchRange(array, 0);
        CollectionPrintUtils.printArray(res);
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        int lindex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                lindex = mid;
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(lindex == -1){
            return new int[]{-1,-1};
        }

        int left =0, high = len - 1;
        int rindex = -1;
        while (left <= high) {
            int mid = left+ (high - left) / 2;
            if (nums[mid] == target) {
                rindex = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[]{lindex,rindex};
    }

}
