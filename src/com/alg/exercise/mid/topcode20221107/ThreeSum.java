package com.alg.exercise.mid.topcode20221107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/3sum/?favorite=2cktkvj
 * 三元组之和为0，先求两数之和，且不能有重复的元素
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = {0,0,0};
        ThreeSum t = new ThreeSum();
        List<List<Integer>>  l =  t.threeSum(a);
        printArray( l);

    }

    private static void printArray(List<List<Integer>> list) {
        list.forEach(l -> {
            String s = "[";
            for (Integer n : l) {
                s = s + n + ",";
            }
            s = s.substring(0, s.length() - 1);
            s += "]";
            System.err.println(s);
        });

    }

    public List<List<Integer>> threeSum(int[] nums) {

        return threeSumTarget(nums, 0);
    }

    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        //先给数组排序
        Arrays.sort(nums);
        //遍历数组中的每个元素，找到匹配的两数之和
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSum = twoSum(nums, target - nums[i], i + 1);
            if (!twoSum.isEmpty()) {
                for (List<Integer> l : twoSum) {
                    l.add(nums[i]);
                    res.add(l);
                }
            }
            //跳过重复的元素
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;

    }


    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        //左右指针，
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int leftNum = nums[left];
            int rightNum = nums[right];
            if (sum < target) {//小于目标值，左边的指针往右移动
                while (left < right && nums[left] == leftNum) {
                    //直接跳过重复的元素
                    left++;
                }

            } else if (sum > target) {
                while (left < right && nums[right] == rightNum) {
                    //直接跳过重复的元素
                    right--;
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(leftNum);
                list.add(rightNum);
                res.add(list);
                while (left < right && nums[right] == rightNum) {
                    //直接跳过重复的元素
                    right--;
                }
                while (left < right && nums[left] == leftNum) {
                    //直接跳过重复的元素
                    left++;
                }
            }
        }
        return res;

    }
}
