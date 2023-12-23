package com.alg.exercise.new20231215hot100.repeat;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * @Author: gu
 * @Date: 2023/12/23 上午9:03
 */
public class MinWindow_06 {

    public static void main(String[] args) {
        MinWindow_06 m =  new MinWindow_06();
        String s  = "a";
        String t  = "aa";
        String res = m.minWindow(s, t);
        System.err.println(res);

    }


    //用map存储t中的字符和出现次数
    //用一个窗口遍历字符串s，也用map，统计字符和出现次数。
    //覆盖t所有字符时，缩小窗口.记录子串。最终保留最小子串。
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        for(int i =0 ;i<t.length();i++){
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0)+1);
        }

        String sub = "";
        int valid = 0;
        int left =0,right = 0;
        Map<Character,Integer> win = new HashMap<>();
         while (right < s.length()){
             char c = s.charAt(right);
             //窗口内数据更新
             if(need.containsKey(c)){
                 win.put(c,win.getOrDefault(c,0)+1);
                 if(win.get(c).equals(need.get(c))){
                     valid++;//如果c出现次数超过了t中的次数，valid 也不会变化，需要通过缩小窗口来取最小
                     //字符串
                 }
             }

             //判断是否缩小窗口
             while(valid == need.size()){
                 //找到了匹配的子串
                 if(sub.equals("") || (right-left+1) < sub.length()){
                     sub = s.substring(left,right+1);
                 }
                 //缩小窗口
                 char l = s.charAt(left);
                 if(need.containsKey(l)){
                     win.put(l,win.get(l)-1);
                     if(win.get(l) < need.get(l)){
                         valid--;
                     }
                 }
                 left++;
             }
             right++;
         }

         return sub;

    }


}
