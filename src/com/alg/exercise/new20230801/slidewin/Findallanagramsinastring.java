package com.alg.exercise.new20230801.slidewin;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 滑动窗口。
 * 使用map（取名need），统计p中每个字符出现的次数。
 * <p>
 * 新建窗口 window，右边界right往右移动，并且记录进入窗口的字符出现次数。
 * 进入窗口的字符是否出现在need中，如果存在，判断出现次数，如果出现次数<need中字符出现次数，窗口右边界right往右移.
 * 如果出现次数=need中字符出现次数,窗口left往右移，剔除不在need中的字符。
 * 如果 window中每个字符及出现次数 与 need完全匹配，则记录子串的起始索引为left的值。
 * <p>
 * 如何判断 window中每个字符及出现次数 与 need完全匹配 ？
 * <p>
 * 定义变量 cal，window中每出现一个字符 出现在need中，并且出现次数等于 need中对应字符的次数，cal++，当cal == need的长度
 * 则完全匹配。
 * <p>
 * window 窗口什么时候缩小？窗口的长度>need窗口的长度（也就是字符串p的长度）
 */
public class Findallanagramsinastring {

    public static void main(String[] args) {
        Findallanagramsinastring f =new Findallanagramsinastring();
        String s ="baa";
        String p ="aa";
        List<Integer> res = f.findAnagrams(s, p);
        CollectionPrintUtils.printList(res);


    }


    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int cal = 0;
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            // window 只记录在need中的字符
            if(need.containsKey(r)){
                window.put(r, window.getOrDefault(r, 0) + 1);
            }

            //统计某个字符出现次数是否一致
            if (need.containsKey(r) && window.get(r).equals(need.get(r))) {
                cal++;
            }
            //判断是否缩小窗口
            while (right - left >= p.length()) {

                //找到了p的异位词
                if (cal == need.size()) {
                    res.add(left);
                }

                char l = s.charAt(left);
                left++;
                //要移除的字符在need里面，并且出现次数一致，cal--
                if(need.containsKey(l)){
                    if(window.get(l).equals(need.get(l))){
                        cal--;
                    }
                    window.put(l,window.get(l)-1);
                }
            }

        }
        return res;
    }
}
