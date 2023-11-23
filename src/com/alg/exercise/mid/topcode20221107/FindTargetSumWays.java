package com.alg.exercise.mid.topcode20221107;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/target-sum/description/?favorite=2cktkvj
 * 目标和
 * <p>
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        int[] nums ={1 };
        int target = 1;
        FindTargetSumWays f = new FindTargetSumWays();
        System.err.println(f.findTargetSumWays(nums,target));

    }

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return dp(nums,0,target);
    }

    Map<String,Integer>  map = new HashMap<>();
    private int dp(int[] nums,int i,int remain){
        //base case
        if(i == nums.length){
            if(remain == 0){
                return 1;
            }
            return 0;
        }
        String key = i+","+remain;
        if(map.containsKey(key)){
            return map.get(key);
        }
        //符号-，remain+nums[i],符号+，remain - nums[i],
        int result = dp(nums,i+1,remain-nums[i])
                +dp(nums,i+1,remain+nums[i]);

        map.put(key,result);
        return result;
    }

}
