package com.alg.exercise.new20230807hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * p是子串
 * 滑动窗口.
 * <p>
 * 字符串中字母出现次数和长度一致时，认为是异位词
 */
public class YiWeiZimu {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int len = s.length();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        int valid = 0;
        while (right < len) {
            char r = s.charAt(right);
            right++;

            if (need.containsKey(r)) {
                //只记录need中存在的
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            //什么情况下缩小窗口。right - left >= p.length
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return res;

    }
}
