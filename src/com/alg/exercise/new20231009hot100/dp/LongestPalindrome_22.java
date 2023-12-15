package com.alg.exercise.new20231009hot100.dp;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 判断回文： 传入两个指针 l,r ,向两边扩散，判断字符串是否是回文
 *
 * @Author: gu
 * @Date: 2023/12/14 下午7:26
 */
public class LongestPalindrome_22 {

    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        for(int i = 0;i < len;i++){
            //以i为中心的最长回文子串
            String s1 = palindrome(s,i,i);
            //以i,i+1 为中心的最长回文子串
            String s2 = palindrome(s,i,i+1);
            res = res.length() > s2.length() ?res :s2;

            res = res.length() > s1.length() ?res :s1;
        }

        return res;

    }

    private String palindrome(String s,int l,int r ){
        while (l>=0 && r<s.length()
            && s.charAt(l) == s.charAt(r)){
           l--;
           r++;
        }
        //以l，r 为中心的最长回文子串
        return s.substring(l+1,r);

    }


}
