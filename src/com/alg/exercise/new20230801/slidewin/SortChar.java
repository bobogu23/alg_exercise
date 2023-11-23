package com.alg.exercise.new20230801.slidewin;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/permutation-in-string/
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 */
public class SortChar {


    public static void main(String[] args) {
        String s1 ="ab";
        String s2 ="eidbaooo";

        SortChar sort = new SortChar();
        System.err.println(sort.contains(s1,s2));

    }

    public boolean contains(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char n = s1.charAt(i);
            need.put(n, need.getOrDefault(n, 0) + 1);
        }
        int left = 0, right = 0;
        int cal = 0;
        boolean res = false;
        Map<Character, Integer> win = new HashMap<>();

        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)) {
                win.put(r, win.getOrDefault(r, 0) + 1);
                //相同的字符，出现次数一致，统计结果+1
                if (need.get(r).equals(win.get(r))) {
                    cal++;
                }
            }

            //窗口缩小
            while (right-left>=s1.length()){
                //判断是否出现了s1的排列
                if(need.size()==cal){
                    res =  true;
                    break;
                }
                char l = s2.charAt(left);
                if(need.containsKey(l)){
                    if(need.get(l).equals(win.get(l))){
                        cal--;
                    }
                    win.put(l,win.get(l)-1);
                }
                left++;
            }
            if(res){
                break;
            }
        }
        return res;
    }

}
