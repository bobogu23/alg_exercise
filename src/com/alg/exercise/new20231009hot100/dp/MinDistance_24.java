package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * <p>
 * 编辑距离：
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 解法：
 * 状态：word1[...i], word2[...j]
 * 选择：
 * i 位置的时候插入一个字符 ，i 不动，j 移动
 * i 位置删除字符，i 移动，j不动
 * i 位置替换一个字符，i 移动，j 移动
 * 如果 word1[i] == word2[j], i,j 移动
 * <p>
 * base case, word1 遍历完了，则加上word2中剩余的字符串长度
 *
 * @Author: gu
 * @Date: 2023/12/14 下午9:48
 */
public class MinDistance_24 {


    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] a : memo) {
            Arrays.fill(a, -1);
        }

        return dp(word1.toCharArray(), word2.toCharArray(), word1.length() - 1, word2.length() - 1);

    }


    private int[][] memo;

    private int dp(char[] cha1, char[] cha2, int i, int j) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        //备忘录
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        //字符相同,不用操作，看前面的字符操作数是多少
        if (cha1[i] == cha2[j]) {
            memo[i][j] = dp(cha1, cha2, i - 1, j - 1);
        } else {
            memo[i][j] = Math.min(
                    Math.min(dp(cha1, cha2, i - 1, j) + 1,
                            dp(cha1, cha2, i, j - 1) + 1),
                    dp(cha1, cha2, i - 1, j - 1) + 1
            );
        }
        return memo[i][j];
    }


    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; i++) {
            //非空字符串转成空字符串，需要的操作数
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            //空字符串 转成 非空字符串需要的操作数
            dp[0][i] = i;
        }

        for(int i =1;i<=m;i++){
            for(int j =1 ;j<=n;j++){
                //字符相同
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {

                    dp[i][j] = min(dp[i-1][j-1]+1,dp[i-1][j]+1,dp[i][j-1]+1);
                }

            }

        }
        return dp[m][n];

    }

    private int min(int a, int b,int c){
        return Math.min(Math.min(a,b),c);
    }

}
