package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.CollectionPrintUtils;

/**
 *
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @Author: gu
 * @Date: 2023/12/26 上午10:27
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] a ={5,7,7,8,8,10};
        SearchRange s  = new SearchRange();
        int[] res = s.searchRange(a, 6);
        CollectionPrintUtils.printArray(res);
    }

    //找到目标值之后，继续往左，往右查找
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return new int[]{-1,-1};
        }

        int len = nums.length;
        int low =0;
        int high = len-1;

        int p = -1;
        while (low <= high){
            int mid = high -(high-low)/2;
            int n = nums[mid];
            if(n == target){
                p = mid;
                high = mid-1;
            }else
            if(n < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        if(p== -1){
            return new int[] {-1,-1};
        }
        int p1= p;

        low = p;
        high = len-1;
        while (low <= high){
            int mid = high -(high-low)/2;
            int n = nums[mid];
            if(n == target){
                p = mid;
                low = mid +1 ;
            }else
            if(n < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return new int[]{p1,p};
    }
}
