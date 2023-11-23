package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 滑动窗口。
 * map<char,int> 记录 p中每个字符出现的次数。
 * <p>
 * 准备一个滑动窗口，[left,right]，窗口扩大，直到== p字符串的长度。同时记录每个字符出现的次数，如果字符相同并且出现次数
 * 也相同，则认为包含了异位词，记录索引：left。
 *
 * @author ben.gu
 */
public class FindAllAnagramsInAString_08 {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        FindAllAnagramsInAString_08 f = new FindAllAnagramsInAString_08();
        CollectionPrintUtils.printList(f.findAnagrams(s,p));
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        Map<Character, Integer> win = new HashMap<>();
        //滑动窗口，当win 长度= need 的长度，判断是否是异位词。并且缩小窗口
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            //只记录need中存在的字符

            if (need.containsKey(cur)) {
                win.put(cur, win.getOrDefault(cur, 0) + 1);
                if (win.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }

            //判断窗口是否要缩小
            while (right - left >= p.length()) {
                if (valid == p.length()) {
                    res.add(left);
                }
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(win.get(leftChar))) {
                        valid--;
                    }

                    win.put(leftChar, win.get(leftChar) - 1);
                }
                left++;
            }
        }
        return res;
    }
}
