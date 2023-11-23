package com.alg.exercise.new20230807hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长子串，给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 滑动窗口，窗口记录字符出现次数，如果出现次数大于1，缩小窗口
 */
public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        String s = " ";
        LongestSubStringWithoutRepeating l = new LongestSubStringWithoutRepeating();
        System.err.println(l.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> win = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        int len = s.length();
        while (right < len){
            char c = s.charAt(right);
            right++;
            win.put(c,win.getOrDefault(c,0)+1);

            while (win.get(c)>1){
                char l = s.charAt(left);
                win.put(l,win.get(l)-1);
                left++;
            }

            res =  Math.max(res,right-left);
        }
        return res;

    }

}
