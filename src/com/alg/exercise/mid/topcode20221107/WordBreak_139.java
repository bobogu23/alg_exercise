package com.alg.exercise.mid.topcode20221107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/word-break/?favorite=2cktkvj
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class WordBreak_139 {
    public static void main(String[] args) {
        WordBreak_139 w = new  WordBreak_139();
        String s ="catsandog";
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.err.println(w.wordBreak(s,list));

    }


    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);


        return dp(s,wordDict,0);
    }

    /**
     * 动态规划，暴力求解
     * 判断字典中的每个单词（长度n）是否跟字符串中的长度为n的前面的子串匹配
     *
     * @param s
     * @param wordDict
     * @param start
     * @return
     */
    int[] memo;

    public boolean dp(String s, List<String> wordDict, int start) {
        //base case
        if (start == s.length()) {
            return true;
        }
        //备忘录，判断是否已经计算过
        if (memo[start] != -1) {
            return memo[start] == 1;
        }
        for (String w : wordDict) {
            int len = w.length();
            if(start + len>s.length()){
                continue;
            }
            String sub = s.substring(start, start + len);
            if (w.equals(sub)) {
                if (dp(s, wordDict, start + len)) {
                    memo[start] = 1;
                    return true;
                }
            }
        }
        memo[start] = 0;
        return false;
    }


}
