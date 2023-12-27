package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * @Author: gu
 * @Date: 2023/12/25 上午9:44
 */
public class CombinationSum {


    //可重复的回溯，可重复就是回溯的时候 start index 不用+1，还是从当前 index开始
    // 终止条件是 候选数字列表之和是target

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> tmp  = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates,target,0);
         return res;
    }

    private void backtrace(int[] candidates,int target,int start){
        //终止条件
        int sum = sum(tmp);
        if(sum == target){
            res.add(new ArrayList<>(tmp));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i = start ;i < candidates.length;i++){
            tmp.addLast(candidates[i]);
            backtrace(candidates,target,i);
            tmp.removeLast();
        }
    }

    private  int sum(LinkedList<Integer> tmp){
        return tmp.stream().mapToInt(Integer::intValue).sum();
    }
}
