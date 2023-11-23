package com.alg.exercise.mid.topcode20221107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/?favorite=2cktkvj
 * 求子集。
 * 回溯算法。
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets_78 {

    public static void main(String[] args) {
        Subsets_78 s = new Subsets_78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = s.subsets(nums);
        printArray(res);

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

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0);
        return result;
    }

    private List<List<Integer>> result = new ArrayList<>();

    private LinkedList<Integer> temp = new LinkedList<>();

    public void backtrace(int[] nums, int start) {
        result.add(new LinkedList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //做选择
            temp.add(nums[i]);
            backtrace(nums, i + 1);
            //撤销选择
            temp.removeLast();
        }

    }


}
