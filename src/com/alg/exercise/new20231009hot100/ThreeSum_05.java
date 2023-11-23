package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
 * 三数之和
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 原始数组先排序，然后可以使用双指针 从左右两端向中间移动，来寻找满足两数之和2sum = 0-第三个数
 * 如果 2sum >  0 - 第三个数,右指针往左移动，
 * 如果 2sum <  0 - 第三个数,左指针往右移动
 *
 * @author ben.gu
 */
public class ThreeSum_05 {
    public static void main(String[] args) {
        ThreeSum_05 t = new ThreeSum_05();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = t.threeSum(nums);
        CollectionPrintUtils.printNestedIntArray(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        //由于要求三数之和，只需遍历到 倒数第三个位置即可
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            //遇到重复的数字 ，跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                //满足三数之和==0
                if (nums[l] + nums[r] + nums[i] == 0) {
                    List<Integer> sums = new ArrayList<>();
                    sums.add(nums[l]);
                    sums.add(nums[r]);
                    sums.add(nums[i]);
                    res.add(sums);
                    //跳过重复的元素
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else if (nums[l] + nums[r] + nums[i] > 0) {
                    r--;
                }
            }
        }
        return res;

    }
}
