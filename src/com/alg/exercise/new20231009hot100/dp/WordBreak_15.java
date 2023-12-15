package com.alg.exercise.new20231009hot100.dp;

import java.util.*;

/**
 *
 * https://leetcode.cn/problems/word-break/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 解法：
 * 类似凑硬币
 *
 * 状态：字符串
 *
 *
 * @Author: gu
 * @Date: 2023/12/13 下午10:14
 */
public class WordBreak_15 {
    public static void main(String[] args) {
        WordBreak_15 w = new WordBreak_15();
        String s = "ccbb";
        String[] a = {"bc","cb"};
        List<String> wordDict = Arrays.asList(a);


        boolean res = w.wordBreak(s,wordDict);
        System.err.println(res);
    }


    public boolean wordBreak(String s, List<String> wordDict) {

        return dp(s,wordDict);
    }

    private Map<String,Boolean> memo = new HashMap<>();

    private boolean dp(String s,  List<String> wordDict){
        //字符串拼接完
        if(s.length()==0){
            return true;
        }
        if(memo.get(s) != null){
            return memo.get(s);
        }

        boolean res = false;
        for(String w: wordDict){
            int pos = s.indexOf(w);
            if(pos ==-1){
                continue;
            }else {
                //去除w，s切成2部分
                String s1 = s.substring(0,pos);
                String s2 = s.substring(pos+w.length());
               res = dp(s1,wordDict) && dp(s2,wordDict);
               if(res){
                   break;
               }
            }
        }

        memo.put(s,res);
        return memo.get(s);
    }


}
