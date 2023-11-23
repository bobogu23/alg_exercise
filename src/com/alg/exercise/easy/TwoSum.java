package com.alg.exercise.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 num 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 遍历数组，
 * 取第一个元素，看后面的元素相加是否等于 target。
 * 取第二个元素，看后面的元素相加是否等于 target。
 * 。。。。。。。
 * for循环,复杂度n^2
 * <p>
 * 哈希表
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(target-nums[i],i);
        }
        return new int[0];
    }
}
