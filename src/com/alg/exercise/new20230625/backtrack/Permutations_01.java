package com.alg.exercise.new20230625.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 全排列，例如，1，2，3  。第一个位置可以是1,2,3 种选择，
 * 第一个位置选择了1之后，第二个位置可以选择 2，3， 第二个位置选择了2之后，第三个位置只能选择3
 * 第一个位置选择了2之后，第二个位置可以选择 1，3， 第二个位置选择了1之后，第三个位置只能选择3
 */
public class Permutations_01 {

    public static void main(String[] args) {
        Permutations_01 p = new Permutations_01();
        int[] nums ={1,2,3};
        List<List<Integer>> res = p.permute(nums);
        res.forEach(l->{
            l.forEach(System.out::print);
            System.out.println();
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,0);
        return results;
    }

    private List<List<Integer>> results = new ArrayList<>();
    private LinkedList<Integer> track = new LinkedList<>();

    private void backtrack(int[] nums,int start){
        //终止条件，遍历到末尾节点
        if(track.size()  == nums.length){
            results.add(new ArrayList<>(track));
            return;
        }
        for(int i = start;i<nums.length;i++){
            //选择
            if(!track.contains(nums[i])){
                track.addLast(nums[i]);
                backtrack(nums,0);
                //撤销选择
                track.removeLast();
            }
        }

    }

}
