package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/25 上午8:20
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        trace(nums,0);
        return res;
    }

    private List<List<Integer>> res =  new ArrayList<>();
    private LinkedList<Integer> tmp =new LinkedList<>();

    private void trace (int[] nums,int start){
        res.add(new ArrayList<>(tmp));
        if(start==nums.length){
            return ;
        }
        for(int i = start ;i < nums.length;i++){
            tmp.add(nums[i]);
            trace(nums,i+1);
            tmp.removeLast();
        }
    }
}
