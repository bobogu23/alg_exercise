package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/25 上午8:12
 */
public class Permute {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        trace(nums);
        return res;
    }

    private void trace(int[] nums) {
        if (trace.size() == nums.length) {
            res.add(new ArrayList<>(trace));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(trace.contains(n)){
                continue;
            }
            //选择
            trace.add(n);
            //回溯
            trace(nums);
            //撤销选择
            trace.removeLast();

        }
    }


}
