package com.alg.exercise.easy.topcode20220829;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长回文
 * https://leetcode.cn/problems/longest-palindrome/?plan=leetcode_75&plan_progress=gb9pjkv
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * <p>
 * 输入:s = "a"
 * 输入:1
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        System.err.println(longestPalindrome(s));
    }


    public static int longestPalindrome(String s) {
        //遍历字符串，使用set存放字符，发现重复的就删除，最终set中存放的是奇数个的元素，随便挑一个放到回文的中间
        Set<Character> sets = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!sets.add(s.charAt(i))) {
                sets.remove(s.charAt(i));
            }
        }

        return sets.size() == 0 ? s.length() : s.length() - sets.size() + 1;

    }
}
