package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/is-subsequence/?plan=leetcode_75&plan_progress=gb9pjkv
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * "ace"是"abcde"的一个子序列，而"aec"不是
 * <p>
 * "aaaaaa"
 * "bbaaaa"
 *
 * "abc"
 * "ahbgdc"
 *
 * a
 * b
 */
public class Subsequence {

    public static void main(String[] args) {
        String s = "aec";
        String t = "abcde";
        System.err.println(isSubsequence(s, t));


    }


    public static boolean isSubsequence(String s, String t) {
        //从头开始遍历 s中的每个字符，s中的每个字符，下标 i, 在t中i及大于i的位置都能找到相同的字符， 则s是t的子序列
        if (s.length() == 0) {
            return true;
        }

        int j = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            char a = s.charAt(i);
            boolean exist = false;
            while (j < t.length()) {
                char b = t.charAt(j);
                j++;
                if (b == a) {
                    exist = true;
                    break;
                }
            }
            if (j == t.length() && !exist) {
                return false;
            }
        }
        return true;
    }
}
