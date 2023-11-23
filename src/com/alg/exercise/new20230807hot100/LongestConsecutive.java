package com.alg.exercise.new20230807hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * //遍历数组，将每个数字放入map中，
 * 定义变量count，统计最长序列长度。
 * 遍历数组，i 是数组的下标，判断nums[i]+1数字是否在map中，如果存在，则count++, nums[i]继续+1;
 */

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] array = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutive l = new LongestConsecutive();
        System.err.println(l.longestConsecutive2(array));

    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            int len = 0;
            int cur = nums[j];
            while (map.containsKey(cur)) {
                len++;
                cur++;
            }
            res = Math.max(res, len);
        }
        return res;
    }


    /**
     * 找到连续序列的第一个数字，然后不断+1，判断是否存在，如果存在 长度记数+1，
     * 如果不存在，更新最大长度值
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int num : set) {
            //说明不是连续序列的第一个
            if (set.contains(num - 1)) {
                continue;
            }
            //找到连续序列的第一个
            int len = 1;
            int n = num;
            while (set.contains(++n)) {
//                n += 1;
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
