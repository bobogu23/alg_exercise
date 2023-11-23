package com.alg.exercise.new20230807hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * 此处要返回数组的下标，因此不能排序
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum ts = new TwoSum();
        ts.twoSum(nums, target);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
               int v = target-nums[i];
               if(map.get(v) != null){
                   return new int[]{i,map.get(v)};
               }
               map.put(nums[i],i);
        }
        return null;
    }
}
