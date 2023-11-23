package com.alg.exercise.new20231009hot100.backtrace;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author ben.gu
 */
public class Permute_01 {

    public static void main(String[] args) {
        int[]nums = {1};
        Permute_01 p = new Permute_01();
        List<List<Integer>> res = p.permute(nums);
        CollectionPrintUtils.printNestedIntArray(res);

    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList();

    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums);
        return res;
    }

    private void backtrace(int[] nums) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (trace.contains(nums[i])) {
                continue;
            }
            trace.add(nums[i]);
            backtrace(nums);
            trace.removeLast();
        }

    }

}
