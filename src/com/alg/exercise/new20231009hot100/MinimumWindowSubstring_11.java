package com.alg.exercise.new20231009hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 使用滑动窗口，记录 字符串t中每个字符以及出现的次数
 * 遍历字符串s，寻找子串 并返回字符串长度
 *
 * @author ben.gu
 */
public class MinimumWindowSubstring_11 {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        MinimumWindowSubstring_11 m = new MinimumWindowSubstring_11();
        System.err.println(m.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        Map<Character, Integer> win = new HashMap<>();
        int valid = 0;
        String res = "";
        while (right < s.length()) {
            char r = s.charAt(right);
            //只记录need中出现的字符
            if (need.containsKey(r)) {
                win.put(r, win.getOrDefault(r, 0) + 1);
                if (win.get(r).equals(need.get(r))) { //如果 win中 r出现次数大于need ，valid 值不变
                    valid++;
                }
            }
            right++;
            //如果找到匹配的字符串，试图缩小窗口，找到长度最小的子串
            while (valid == need.size()) {
                String sub = s.substring(left, right);
                res = res.equals("") ? sub :
                        res.length() < sub.length() ? res : sub;
                char c = s.charAt(left);
                if (need.containsKey(c)) {
                    if (need.get(c).equals(win.get(c))) {
                        valid--;
                    }
                    win.put(c, win.get(c) - 1);
                }
                left++;
            }
        }
        return res;

    }
}
