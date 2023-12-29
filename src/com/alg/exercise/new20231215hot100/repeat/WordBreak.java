package com.alg.exercise.new20231215hot100.repeat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 * @Author: gu
 * @Date: 2023/12/27 下午6:08
 */
public class WordBreak {

    //类似凑硬币问题.用字典表中的字符串，去字符串s中搜索，是否存在一致的子串，如果存在。
    //将匹配的子串剔除，拆分成2个子串，再继续用字典表中的字符串匹配。

    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s,wordDict);
    }

    private Map<String,Boolean> memo = new HashMap<>();
    private boolean dp(String s, List<String> wordDict){
        //匹配完了
        if(s== null || s.equals("")){
            return  true;
        }
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        //字典表中的字符串去匹配字符串s
        boolean match = false;
        for(String w : wordDict){
            boolean exist = s.contains(w);
            if(exist){
                int i = s.indexOf(w);
                String left = "";
                if(i>0){
                    left = s.substring(0,i);
                }
                String right = "";
                if(i+w.length()<s.length()){
                    right = s.substring(i+w.length());
                }
                boolean leftmatch = dp(left,wordDict);
                boolean rightmatch = dp(right,wordDict);
                if(rightmatch && leftmatch){
                    match = true;
                    break;
                }
            }
        }
        memo.put(s,match);
        return match;
    }


}
