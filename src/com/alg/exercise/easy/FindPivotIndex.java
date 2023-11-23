package com.alg.exercise.easy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-pivot-index/
 * <p>
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 */
public class FindPivotIndex {

    public static void main(String[] args) {

    }

    // 设下标 为i，假如下标左右两侧所有元素之和 sum 相等，所有元素之和为 total,则 num[i]+2*sum = total ,
    //num[i] = total -  2 * sum
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for(int i =0 ;i < nums.length;i++){
            if(nums[i] == total - 2* sum){
                return i;
            }
            sum += nums[i];
        }
        return -1;

    }

}
