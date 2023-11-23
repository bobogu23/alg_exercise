package com.alg.exercise.new20230811dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/edit-distance/
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * dp  备忘录
 * dp table
 */
public class MinDistance {

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        MinDistance md = new MinDistance();
        System.err.println(md.minDistance(word1, word2));
        System.err.println(md.minDistance2(word1, word2));
    }

    /**
     * 备忘录+递归
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(word1,m-1,word2,n-1);
    }

    private int[][] memo;

    private int dp(String word1, int i, String word2, int j) {
        //base case
        if (i == -1) {
            //word1字符串操作完成
            return j + 1;
        }
        if (j == -1) {
            //word2字符串操作完成
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //i,j位置上的字符一致，i,j 从后 往前移动，不需要操作
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(word1, i - 1, word2, j - 1);
        } else {
            memo[i][j] = min(
                    dp(word1, i - 1, word2, j) + 1,
                    dp(word1, i, word2, j - 1) + 1,
                    dp(word1, i - 1, word2, j - 1) + 1
            );
        }
        return memo[i][j];
    }


    /**
     * dp table
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //word1[0..i],word[0...j] 最小编辑距离 dp[i+1][j+1]
        int[][] dp = new int[m + 1][n + 1];
        //base case . dp[i][0] ,dp[0][j]
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1,
                            dp[i - 1][j - 1] + 1
                    );
                }

            }
        }
        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
