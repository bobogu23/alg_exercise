package com.alg.exercise.mid.topcode20221107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinations {
    static String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        List<String> res1 = comb(digits);
        res.forEach(System.out::println);
        System.err.println("=======================");
        res1.forEach(System.out::println);
    }

    static List<String> res = new LinkedList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        backTrace(digits, 0, new StringBuilder());
        return res;
    }

    private static void backTrace(String digits, int start, StringBuilder sb) {
        if (digits.length() == sb.length()) {//终止条件
            //到达回溯树底部
            res.add(sb.toString());
            return;
        }
        for (int j = start; j < digits.length(); j++) {
            int digit = digits.charAt(j) - '0';
            for (char c : letters[digit].toCharArray()) {
                //做选择
                sb.append(c);
                //回溯
                backTrace(digits, j + 1, sb);
                //撤销选择
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    static List<String> r = new ArrayList<>();

    public static List<String> comb(String s) {
        if (s.isEmpty()) {
            return r;
        }
        bt(s, 0, new StringBuilder());
        return r;
    }

    private static void bt(String s, int start, StringBuilder stringBuilder) {
        //终止条件，字母组合长度等于s的长度
        if (s.length() == stringBuilder.length()) {
            r.add(stringBuilder.toString());
            return;
        }
        for (int j = start; j < s.length(); j++) {
            int index = s.charAt(j) - '0';
            for (char c : letters[index].toCharArray()) {
                stringBuilder.append(c);
                bt(s, j + 1, stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }


}
