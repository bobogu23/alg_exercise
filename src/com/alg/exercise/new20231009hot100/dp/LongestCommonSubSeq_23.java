package com.alg.exercise.new20231009hot100.dp;

/**
 *
 * https://leetcode.cn/problems/longest-common-subsequence/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
 * （也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 状态： s[...i],s[...j] 子序列
 * 选择：在公共子序列中或者不在公共子序列中
 *
 * dp[i][j] : 表示 s1[1..i],s2[1..j]的最长公共子序列长度
 *
 * base case dp[0][j] = 0, dp[i][0] = 0
 *
 * 如果 s1[i] == s2[j],则 最长公共子序列长度 = dp[i-1][j-1] + 1
 * 如果 s1[i] != s2[j],则 最长公共子序列长度= max(dp[i-1][j],dp[i][j-1])
 *
 * dp[][]数组长度为字符串长度+1，可以避免考虑边界问题。
 *
 * @Author: gu
 * @Date: 2023/12/14 下午9:14
 */
public class LongestCommonSubSeq_23 {


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1;i<= m;i++){
            for(int j =1 ;j <=n;j++){
                if(text1.charAt(i-1) == text1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[m][n];

    }


}
