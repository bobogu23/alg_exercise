package com.alg.exercise.new20230801.slidewin;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */
public class MinWindow {

    public static void main(String[] args) {
        String s  ="a" ;
        String t  ="aa" ;
        MinWindow mw = new MinWindow();
        System.err.println(mw.minWindow(s,t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        String res = "";
        int cal = 0;
        Map<Character, Integer> win = new HashMap<>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                win.put(r, win.getOrDefault(r, 0) + 1);
                if (win.get(r).equals(need.get(r))) {
                    cal++;
                }
            }

            //找到涵盖t的子串,窗口缩小
            while (cal == need.size()) {
                //需要在循环中不断判断最小的子串
                String sub = s.substring(left, right);
                res = res.equals("") ? sub : res.length() > sub.length() ? sub : res;

                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (win.get(l) .equals( need.get(l))) {
                        cal--;
                    }
                    win.put(l, win.get(l) - 1);
                }
            }
        }

        return res;
    }

}
