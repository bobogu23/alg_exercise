package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/longest-common-prefix/?plan=leetcode_75&plan_progress=zci8d5e
 * 最长公共前缀
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

    }

    //依次遍历每个字符串，从第一位开始判断字符串上每个字符是否相同，到达不同的字符终止，即为最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int strSize = strs.length;
        int maxLength = strs[0].length();
        for (int i = 0; i < maxLength; i++) {//遍历字符串中的每个字符
            char firstStrChar = strs[0].charAt(i);
            for (int j = 1; j < strSize; j++) {//遍历每个字符串
                 if( i == strs[j].length() || firstStrChar != strs[j].charAt(i)){//遍历到长度最小的字符串了，或者遇到不同的字符了，即可终止
                     return strs[0].substring(0,i);
                 }
            }
        }
        return strs[0];
    }
}
