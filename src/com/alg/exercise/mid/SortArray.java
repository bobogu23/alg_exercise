package com.alg.exercise.mid;

import java.util.Random;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 快速排序
 */
public class SortArray {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        SortArray sortArray = new SortArray();
        sortArray.sortArray(arr);
        System.err.println(arr);

    }

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void  quickSort(int[] nums,int start,int end) {
        if(start >= end){
            return;
        }
        int pivot = partition(nums,start,end);
        quickSort(nums,0,pivot-1);
        quickSort(nums,pivot+1,end);
    }

    public int partition(int[] nums,int start,int end){
        //start到i-1 的部分是已经处理区间,都小于pivot,遍历数组中的i到end，将每个元素与pivot比较,小于pivot的加入到
        //已处理数组的尾部nums[i]
         int pivot = nums[end];
        int i = start;
        for(int j = i;j<end;j++){
            if(nums[j] < pivot){
              swap(nums,i,j);
              i++;
            }
        }
        swap(nums,i,end);
        return i;
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
         nums[i] = nums[j];
         nums[j] = tmp;
    }

}
