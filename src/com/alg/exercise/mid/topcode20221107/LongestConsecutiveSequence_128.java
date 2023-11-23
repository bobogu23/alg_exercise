package com.alg.exercise.mid.topcode20221107;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/?favorite=2cktkvj
 *
 *
 *给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 */
public class LongestConsecutiveSequence_128 {

    public static void main(String[] args) {
        int[] a = {0,3,7,2,5,8,4,6,0,1};
        LongestConsecutiveSequence_128 s = new LongestConsecutiveSequence_128();
        int len = s.longestConsecutive(a);
        System.err.println(len);
    }

    /**
     * 用一个set 存储数组中的元素，方便判断元素是否存在。
     * <p>
     * 遍历数组中的每个元素，判断是否是连续序列的第一个，如果是，往后+1，
     * 看对应的元素是否在set中，同时计算序列的长度
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Arrays.stream(nums).forEach(n -> set.add(n));
        int maxLen = 0;
        for (int n : nums) {
            //不是连续序列的第一个
            if (set.contains(n - 1)) {
                continue;
            }
            //是连续序列的第一个
            int len = 1;
            while (set.contains(n + 1)) {
                len++;
                n++;
            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }

    private Set<Integer> set = new HashSet<>();


}
