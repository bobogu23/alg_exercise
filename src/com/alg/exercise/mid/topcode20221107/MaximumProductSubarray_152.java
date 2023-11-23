package com.alg.exercise.mid.topcode20221107;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/?favorite=2cktkvj
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 * <p>
 */
public class MaximumProductSubarray_152 {
    public static void main(String[] args) {
        int[] a = {-2, 3, -4};
        MaximumProductSubarray_152 m = new MaximumProductSubarray_152();
        int max = m.maxProduct(a);
        int max2 = m.maxProductV2(a);
        System.err.println(max);
        System.err.println(max2);
    }


    int max = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int multi = nums[i];
            max = Math.max(max, multi);
            for (int j = i + 1; j < nums.length; j++) {
                multi = multi * nums[j];
                max = Math.max(max, multi);
            }
        }

        return max;

    }

    /**
     * 动态规划
     * fmax(i)= max(fmax(i-1)* a(i),a(i),fmin(i-1)* a(i))
     * 以i-1结尾的子数组乘积的最大值* a(i),
     * a(i)
     * 以i-1结尾的子数组乘积的最小值* a(i),
     * <p>
     * 三者取最大
     * <p>
     * 怎么体现连续子序列的？
     *
     * @param nums
     * @return
     */
    public int maxProductV2(int[] nums) {
        int len = nums.length;
        int[] maxMulti = new int[len];
        int[] minMulti = new int[len];
        System.arraycopy(nums, 0, maxMulti, 0, len);
        System.arraycopy(nums, 0, minMulti, 0, len);
        for (int i = 1; i < len; i++) {
            //如果nums[i] 最大，则前面的i-1结尾的数组是一个子序列，新的子序列从i开始
            //****遍历数组时，每次都计算当前位置之前的子数组的乘积最大值。
            maxMulti[i] = Math.max(maxMulti[i - 1] * nums[i],
                    Math.max(minMulti[i - 1] * nums[i], nums[i]));


            minMulti[i] = Math.min(minMulti[i - 1] * nums[i],
                    Math.min(maxMulti[i - 1] * nums[i], nums[i]));
        }

        int res = nums[0];
        for (int i = 1; i < maxMulti.length; i++) {
            res = Math.max(maxMulti[i], res);
        }
        return res;


    }

}
