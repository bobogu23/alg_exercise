package com.alg.exercise.mid.topcode20221107;

import java.io.FileReader;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?favorite=2cktkvj
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] array = {};
        SearchRange r = new SearchRange();
        int[] res = r.searchRange(array, 0);

        r.printArray(res);
    }

    private void printArray(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        Arrays.stream(a).forEach(e -> sb.append(e).append(","));
        String s = sb.substring(0, sb.length() - 1) + "]";
        System.err.println(s);
    }

    /***
     * 二分查找 左边界，右边界
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        int rightBound = rightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    private int leftBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target == nums[mid]) {
                //收缩右边界
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }
        //跳出while循环的条件 low>right. target 如果比数组中的任何元素都大，则low一直
        //右移，可能超出数组长度
        if (low >= nums.length || nums[low] != target) {
            return -1;
        }
        return low;
    }

    private int rightBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target == nums[mid]) {
                //收缩左边界
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]){
                low = mid + 1;
            }
        }
        //跳出while循环的条件 low > right,此时low = mid+1
        //如果 target 非常小，比数组中的任何元素都小，high = mid-1，可能会小于0
        if ((low - 1) < 0 || nums[low - 1] != target) {
            return -1;
        }
        return low - 1;
    }
}
