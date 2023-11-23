package com.alg.exercise.new20230422.array;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 回文串有两种: aba,  caac 。奇数个字符，偶数个字符。
 * 奇数个字符，中间字符两边的字符一一对应相同。
 * 偶数个字符，中间的两个字符开始一一对应相同。
 */
public class LongestPalindrome_06 {


    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            //以i为中心，最长回文串
            //以i，i+1为中心，最长回文串
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }


    private String palindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }else {
                break;
            }
        }
        // 假设s = aa。i=0,j=1。最后 i=-1,j=2。
        return s.substring(i+1,j);
    }


}
