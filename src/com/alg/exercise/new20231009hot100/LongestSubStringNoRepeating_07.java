package com.alg.exercise.new20231009hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 滑动窗口，两个指针，第一个指针r不断往后移动，遍历字符串，并且用Map记录当前遍历过的字符和出现次数。
 * 如果遇到重复的字符c，第二个指针l往后移动，直到字符c出现次数为1.
 * 最长子串的长度 = r-l
 *
 * @author ben.gu
 */
public class LongestSubStringNoRepeating_07 {
    public static void main(String[] args) {
        String s  = "bbbbb";
        LongestSubStringNoRepeating_07 l = new LongestSubStringNoRepeating_07();
        System.err.println(l.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int res = 0;
        //存放每个字符出现次数
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            char cur = s.charAt(right);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            right++;

            while (map.get(cur) > 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }

}
