package com.alg.exercise.easy.topcode20220829;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
。
 https://leetcode.cn/problems/isomorphic-strings/?plan=leetcode_75&plan_progress=gb9pjkv

 输入：s = "egg", t = "add"
 输出：true

 s = "foo", t = "bar"
 输出：false

 输入：s = "paper", t = "title"
 输出：true

 1 <= s.length <= 5 * 104
 t.length == s.length
 s 和 t 由任意有效的 ASCII 字符组成

 */
public class Isomorphic {

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.err.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        //遍历字符串s中的每个字符，放入list，获取跟当前字符相同的字符在list中的位置，t中相同位置的字符也应该于当前字符相同
        //s中没有相同的字符，t中也必须没有相同的字符
        List<Character> list1 = new ArrayList<>(s.length());
        List<Character> list2 = new ArrayList<>(s.length());
        for(int i =0 ; i < s.length(); i++){
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            int index = -1;
            if((index = list1.indexOf(char1)) >-1 && list2.get(index) != char2){
                return false;
            }else if((index = list1.indexOf(char1)) == -1 && list2.indexOf(char2) > -1 ){
                return false;
            }
            list1.add(char1);
            list2.add(char2);
        }
        return true;
    }
}
