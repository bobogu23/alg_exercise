package com.alg.exercise.new20230811dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-break/
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * 回溯算法，加备忘录
 */
public class WordBreak {
    private Set<String> wordDict;
    int[] memo;


    public static void main(String[] args) {
       WordBreak wb = new WordBreak();
       String s = "catsandog";
        List<String> wordDict =  new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("sand");
        wordDict.add("dog");
        wordDict.add("and");
        wordDict.add("cat");
        System.err.println(wb.wordBreak(s,wordDict));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s,0);
    }

    private boolean dp(String s, int i) {
        //base case
        if (i == s.length()) {
            return true;
        }

        //使用备忘录判断
        if (memo[i] != -1) {
            return memo[i] == 1;
        }

        //遍历s[i...]结尾的所有前缀
        for (int len = 1; len + i <= s.length(); len++) {
            String prefix = s.substring(i,i+len);
            if(wordDict.contains(prefix)){
                //判断 i+len之后的字符串是否能拼凑出
                boolean sub = dp(s,i+len);
                if(sub){
                    memo[i] =1 ;
                    return true;
                }
            }
        }
        memo[i] = 0;
        return false;
    }


}
