package com.alg.exercise.mid.topcode20221107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/?favorite=2cktkvj
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 * 全排列，
 */
public class Permutations_40 {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5};

        Permutations_40 p = new Permutations_40();
        List<List<Integer>> list = p.permute(a);
        printArray(list);
        System.err.println("------------");
        list = p.permute1(a);
        printArray(list);
    }

    private List<List<Integer>> res1 = new ArrayList<>();
    private LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> permute1(int[] a){
        if(a.length == 0){
            return res;
        }
        bt(a,0);
        return res1;
    }

    private void bt(int[] a ,int start){
        if(temp.size() == a.length){
            res1.add(new ArrayList<>(temp));
        }
        for(int i =start;i<a.length;i++){
            //选择
            if(!temp.contains(a[i])){
                temp.add(a[i]);
                bt(a,0);
                //撤销选择
                temp.removeLast();
            }
        }
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

    /**
     * 回溯算法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,0);
        return res;
    }


    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    private void backtrack(int[] nums, int start) {
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            //选择
            if(!track.contains(nums[i])){
                track.add(nums[i]);
                backtrack(nums,0);
                //撤销选择
                track.removeLast();
            }
        }

    }
}
