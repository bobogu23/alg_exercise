package com.alg.exercise.new20230801.slidewin;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 滑动窗口。
 * left 表示窗口左边的index，right表示窗口右边的index，
 * 窗口扩大，right 往右移动，并且记录遍历过的字符，和出现次数。每记录一个字符A，判断出现次数是否大于1.
 * 如果大于1，窗口缩小，left index往右移动，并且在窗口缩小后，将移除窗口的字符出现次数-1。
 * 直到字符A出现次数<=1，更新最长子串的长度。进入下一轮循环，窗口扩大，right往右移动.
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "bbbbb";
        LengthOfLongestSubstring l  = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring(s));

    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int len = s.length();
        int res = 0;
        while (right < len) {
            char r = s.charAt(right);
            //记录字符出现次数
            window.put(r, window.getOrDefault(r, 0) + 1);
            right++;

            //判断窗口中是否出现字符r重复
            while (window.get(r) > 1) {
                //窗口缩小
                char l = s.charAt(left);
                left++;
                window.put(l, window.get(l) - 1);
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

}

