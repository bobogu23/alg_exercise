package com.alg.exercise.new20231009hot100.skil;

/**
 * https://leetcode.cn/problems/sort-colors/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 解法：
 * 单指针，
 *   指针p，表示交换的位置
 *   遍历数组 将0放到头部。0的最后一个位置+1 -> p.
 *   遍历数组，将1放到 p后面，p同时往后移动。
 *
 *
 * @Author: gu
 * @Date: 2023/12/15 下午12:32
 */
public class SortColor_03 {


    public void sortColors(int[] nums){
        int n = nums.length;
        int p =0;
        //交换 0
        for(int i  =0;i < n;i++){
            if(nums[i] == 0){
                swap(nums,p,i);
                p++;
            }
        }

        //交换 1
        for(int i = p;i<n;i++){
            if(nums[i] == 1){
                swap(nums,p,i);
                p++;
            }
        }

    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[b];
        nums[b] = nums[a];
        nums[a] = tmp;

    }
}
