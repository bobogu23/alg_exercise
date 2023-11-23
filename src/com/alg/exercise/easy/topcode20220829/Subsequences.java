package com.alg.exercise.easy.topcode20220829;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/split-array-into-consecutive-subsequences/
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列
 * ，其中每个子序列都由连续整数组成。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 */
public class Subsequences {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,4,5};
        System.err.println(isPossible(array));
    }


    /**
     * 先排序，（题目中已经排序好了）
     * 统计每个数字出现的频率
     * 数字优先拼接在现有的子序列后面。
     * 如果有连续3个数字出现的频率都大于0，则可以组成一个子序列
     * 如果一个数字拼接到了某个子序列之后，那么它之后的数字被需求的次数+1
     *
     * @param nums
     * @return
     */
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        //统计出现次数
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for (int i : nums) {
            if (freq.get(i) == 0) {
                continue;
            }
            //先判断当前数字能否拼接到其他子序列之后
            if (need.getOrDefault(i, 0) > 0) {//需要当前数字
                //出现次数-1
                freq.put(i,freq.get(i)-1);
                //对i的需求-1
                need.put(i,need.get(i)-1);
                //对i+1的需求+1
                need.put(i+1,need.getOrDefault(i+1,0)+1);
            }else if(freq.getOrDefault(i,0)>0
                   && freq.getOrDefault(i+1,0)>0
                    && freq.getOrDefault(i+2,0)>0){
                //出现次数-1
                freq.put(i,freq.get(i)-1);
                freq.put(i+1,freq.get(i+1)-1);
                freq.put(i+2,freq.get(i+2)-1);
                //对i+3的需求+1
                need.put(i+3,need.getOrDefault(i+3,0)+1);
            }else {
                return false;
            }
        }
        return true;
    }

}
