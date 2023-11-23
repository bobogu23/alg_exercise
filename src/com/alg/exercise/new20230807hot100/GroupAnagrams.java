package com.alg.exercise.new20230807hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 异位词，两个单词长度相同，每个字符出现次数相同。利用此规则给字符串编码，将编码相同的字符串放在一起
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sameWord = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String w = encode(strs[i]);
            sameWord.putIfAbsent(w, new ArrayList<>());
            sameWord.get(w).add(strs[i]);
        }
        //将异位词分组
        List<List<String>> res = new ArrayList<>();
        for (List<String> l : sameWord.values()) {
            res.add(l);
        }
        return res;
    }

    private String encode(String s) {
        //计算每个字母出现的次数
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            //计算字符 相对于字母a的位置
            int c = s.charAt(i) - 'a';
            chars[c]++;
        }
        return new String(chars);
    }

}
