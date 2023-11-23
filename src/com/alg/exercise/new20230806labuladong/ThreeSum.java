package com.alg.exercise.new20230806labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/3sum/?envType=list&envId=9zwo3ww5
 * 三数之和。
 * <p>
 * 原始数组排序，
 * 从数组第一个元素开始 nums[i]，使用双指针，指向右边数组的首尾， 计算元素右边的数组 两数之和 = -nums[i]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //跳过 nums[j] 重复的元素
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    //跳过 nums[k] 重复的元素
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    //移动双指针
                    j++;
                    k--;
                } else if (sum < 0) {
                    //和太小了，左指针往右移动（往元素增大的方向）
                    j++;
                } else {
                    //和太大了，左指针往左移动（往元素减小的方向）
                    k--;
                }
            }

        }

        return ans;
    }


}
