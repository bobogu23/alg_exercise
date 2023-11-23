package com.alg.exercise.new20231009hot100;

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
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 对单词进行编码，编码相同的单词放到一起
 *
 * @author ben.gu
 */
public class Zimuyiweicifenzu_01 {

    public static void main(String[] args) {
        Zimuyiweicifenzu_01 z  = new Zimuyiweicifenzu_01();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = z.groupAnagrams(strs);
        System.err.println(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> encodeMap = new HashMap<>();
        for(String s : strs){
            String encoded = encode(s);
            encodeMap.putIfAbsent(encoded,new ArrayList<>());
            encodeMap.get(encoded).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> l : encodeMap.values()){
            res.add(l);
        }
        return res;
    }

    //统计字母出现次数做为编码
    private String encode(String word) {
        char[] array = new char[26];
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i)- 'a';
            array[pos]++;
        }
        return new String(array);
    }

}
