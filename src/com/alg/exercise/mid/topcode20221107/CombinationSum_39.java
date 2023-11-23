package com.alg.exercise.mid.topcode20221107;

import javax.naming.spi.ResolveResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/description/?favorite=2cktkvj
 * <p>
 * 组合总和
 */
public class CombinationSum_39 {
    public static void main(String[] args) {
        CombinationSum_39 c = new CombinationSum_39();
        int[] candidates  = {2};
        List<List<Integer>> results = c.combinationSum(candidates, 1);
        printArray(results);
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

    private List<List<Integer>> res = new LinkedList<>();

    /**
     * 回溯算法
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backTrack(candidates,target,0);
        return res;
    }

    private LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    private void backTrack(int[] candidates, int target, int start) {
        if (trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //选择
            track.add(candidates[i]);
            trackSum += candidates[i];
            //可重复选择，start =i
            backTrack(candidates, target, i);
            //撤销选择
            trackSum -= candidates[i];
            track.removeLast();
        }

    }

}
