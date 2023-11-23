package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

/**
 * https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author ben.gu
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {-1, -100, 3, 99};
        RotateArray r = new RotateArray();
        r.rotate(arr, 2);
        CollectionPrintUtils.printArray(arr);
    }


    public void rotate(int[] nums, int k) {

        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < a.length; i++) {
           nums[i] = a[i];
        }
    }

}
