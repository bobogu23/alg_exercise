package com.alg.exercise.new20231009hot100.backtrace;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author ben.gu
 */
public class Subsets_02 {

    public static void main(String[] args) {
        int[] array = {1,2,3};
        Subsets_02 s = new Subsets_02();
        List<List<Integer>> res = s.subsets(array);
        CollectionPrintUtils.printNestedIntArray(res);

    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums,0);
        return res;
    }

    private void backtrace(int[] nums,int i){
        res.add(new ArrayList<>(tmp));
        for(int j=i;j<nums.length;j++){
            int num = nums[j];
            tmp.add(num);
            backtrace(nums,j+1);
            tmp.removeLast();
        }
    }

}
