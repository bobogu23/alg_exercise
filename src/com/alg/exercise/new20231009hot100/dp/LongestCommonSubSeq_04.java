package com.alg.exercise.new20231009hot100.dp;

import java.util.Arrays;

/**
 * 最长公共子序列长度
 *
 * @Author: gu
 * @Date: 2023/12/11 下午11:04
 */
public class LongestCommonSubSeq_04 {

    public int longestCommonSubSeq(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for(int[] a :memo){
            Arrays.fill(a,-1);

        }
        return dp(s1,0,s2,0);
    }

    int[][] memo;

    //计算s[i...],s[j...] 最长公共子序列长度
    private int dp(String s1,int i ,String s2,int j){
        //base case
        if(i== s1.length() || j == s2.length()){
            return 0;
        }
        //备忘录
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        //s[i]==s[j]
        if(s1.charAt(i) == s2.charAt(j)){
            memo[i][j] =  1 + dp(s1,i+1,s2,j+1);
        }else {
            //s[i] != s[j]
            memo[i][j] = 1+ Math.max(
                    dp(s1,i+1,s2,j),
                    dp(s1,i,s2,j+1)
            );
        }
        return memo[i][j];
    }

}
