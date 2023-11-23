package com.alg.exercise.new20230806labuladong;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/?envType=list&envId=9zwo3ww5
 * 最长回文。
 * 从中间相两边扩散，判断回文
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrom(s, i, i);
            String s2 = palindrom(s, i, i + 1);

            res = s1.length() > res.length() ? s1 : res;
            res = s2.length() > res.length() ? s2 : res;
        }
        return res;
    }

    private String palindrom(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        //不满足条件时，i 已经多减1，j多加了1
        return s.substring(i+1,j);
    }

}
