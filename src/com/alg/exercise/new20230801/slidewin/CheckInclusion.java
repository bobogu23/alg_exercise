package com.alg.exercise.new20230801.slidewin;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/MPnaiL/
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class CheckInclusion {
    public static void main(String[] args) {
        CheckInclusion ci = new CheckInclusion();
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.err.println(ci.checkInclusion(s1, s2));
    }


    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char n = s1.charAt(i);
            need.put(n, need.getOrDefault(n, 0) + 1);
        }
        int left = 0, right = 0;
        int cal = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    cal++;
                }
            }
            //窗口缩小
            while (right - left >= s1.length()) {
                if (cal == need.size()) {
                    return true;
                }
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        cal--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }

        }
        return false;
    }

}
