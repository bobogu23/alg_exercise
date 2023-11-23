package com.alg.exercise.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr ={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(arr);
        System.err.println(lists);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return answers;
        }
        //从小到大排序
        Arrays.sort(nums);
        //从左开始,从指定元素右边部分的数组的两边开始遍历,找出相加等于指定值的元素
        for (int i = 0; i < nums.length - 2; i++) {
            //nums[i] 大于0,那么后面的元素都大于0，三数之和不可能等于0
            if (nums[i] > 0) {
                break;
            }
            //数据重复,直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if(nums[start]+nums[end] == sum){
                    answers.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                    while (start<end && nums[start]==nums[start-1]){
                        start++;
                    }
                    while (start<end && nums[end]==nums[end+1]){
                        end--;
                    }
                 }//从左开始，两数之和小于 sum,往右移动左边的下标
                else if(nums[start]+nums[end] < sum){
                    start++;
                }else {
                    end--;
                }
            }
        }
        return answers;
    }
}
