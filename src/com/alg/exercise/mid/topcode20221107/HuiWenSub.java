package com.alg.exercise.mid.topcode20221107;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindromic-substrings/?favorite=2cktkvj
 * 回文子串
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class HuiWenSub {
    public static void main(String[] args) {
        HuiWenSub h = new HuiWenSub();
        String s = "aaa";
        System.err.println(h.countSubstrings(s));

    }


    //回溯
    public int countSubstrings(String s) {
        int n = s.length();
        int num = n;//单个字符是一个回文子串
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i++)//遍历回文中心点
        {
            //以一个点为中心点，向两边扩展
            int l = i - 1;
            int r = i + 1;
            System.err.println("l:"+l+",r:"+r);
            while (l >= 0 && r < n && array[l--] == array[r++]) {
                num++;
            }
            System.err.println("==================");
            //以两个节点为中心，向两边扩展
            l = i;
            r = i + 1;


            System.err.println("l1:"+l+",r1:"+r);
            while (l >= 0 && r < n && array[l--] == array[r++]) {
                num++;
            }

        }
        return num;
    }


    private boolean isHuiWen(String s) {
        if (s.length() == 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
