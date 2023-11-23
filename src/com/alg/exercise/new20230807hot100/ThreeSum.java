package com.alg.exercise.new20230807hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //三数之和，i只需到倒数第三个位置即可
        for (int i = 0; i < nums.length - 2; i++) {
            //跳过重复的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while (j<k && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }else if(nums[i]+nums[j]+nums[k] < 0){
                     j++;
                }else {
                    k--;
                }
            }

        }
      return res;
    }
}
