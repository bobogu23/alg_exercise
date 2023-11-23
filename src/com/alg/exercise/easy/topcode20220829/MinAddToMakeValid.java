package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
 */
public class MinAddToMakeValid {


    public int minAddToMakeValid(String s) {
        int need = 0;//右括号的需求量
        int res = 0;//插入次数
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(')) {
                need++;
            } else if (c.equals(')')) {
                need--;

                if (need == -1) {//右括号多了
                    res++;
                    need = 0;
                }
            }
        }
        return res + need;
    }


}
