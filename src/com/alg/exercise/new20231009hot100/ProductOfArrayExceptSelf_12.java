package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 类似于接雨水问题，遍历数组，分别计算每个元素左边元素的乘积，右边元素的乘积
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * @author ben.gu
 */
public class ProductOfArrayExceptSelf_12 {

    public static void main(String[] args) {
        int[] nums ={1,2,3,4};
        ProductOfArrayExceptSelf_12 p = new ProductOfArrayExceptSelf_12();
        int[] res = p.productExceptSelf(nums);
        CollectionPrintUtils.printArray(res);
    }

    public int[] productExceptSelf(int[] nums) {
            int[] lmulti = new int[nums.length];
            int[] rmulti = new int[nums.length];
            lmulti[0] = 1;//nums[0]左边没有元素，左边元素乘积为1
            rmulti[nums.length - 1] = 1;


            for (int i = 1; i < nums.length; i++) {
                lmulti[i] = lmulti[i - 1] * nums[i - 1];
            }
            for (int i = nums.length - 2; i >= 0; i--) {
                rmulti[i] = rmulti[i + 1] * nums[i + 1];
            }

            int[] answer = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                answer[i] = lmulti[i] * rmulti[i];
            }
            return answer;
    }
}
