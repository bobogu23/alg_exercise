package com.alg.exercise.new20230625.backtrack;
/**
 * https://leetcode.cn/problems/VvJkup/
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 * 回溯算法
 * 遍历数组，
 * 先选择 第一个元素，那么接下来 可以选择第二或者第三个元素，第三个元素 可以选择第三或者第二个元素
 * 先选择 第二个元素，那么接下来 可以选择第一或者第三个元素，第三个元素 可以选择第三或者第一个元素
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = {1};
        List<List<Integer>> permute = p.permute(nums);
        p.printList(permute);

    }

    private void printList(List<List<Integer>> res){
        for (List<Integer> re : res) {
            StringBuilder sb = new StringBuilder("[");
            re.forEach(e->sb.append(e).append(","));
            System.out.println(sb.substring(0,sb.length()-1)+"]");
        }
    }


    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        track(nums,trace,used);
        return result;
    }

    private void track(int[] nums,LinkedList<Integer> trace,boolean[] used){
        if(trace.size() == nums.length){
            result.add(new ArrayList<>(trace));
        }
        for(int i =0;i < nums.length;i++){
            if(used[i]){
                continue;
            }
            trace.add(nums[i]);
            used[i] = true;
            //进入回溯
            track(nums,trace,used);
            //取消选择
            trace.removeLast();
            used[i] = false;
        }
    }


}
