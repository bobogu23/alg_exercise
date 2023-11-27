package com.alg.exercise.new20231009hot100.backtrace;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author ben.gu
 */
public class LetterCombinations_03 {
    public static void main(String[] args) {
        LetterCombinations_03 lc = new LetterCombinations_03();
//        String s ="23";
        String s ="2";
        List<String> strings = lc.letterCombinations(s);
        CollectionPrintUtils.printList(strings);
    }

    private String[] array = {null, "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};

    List<String> res = new ArrayList<>();
    LinkedList<Character> tmp = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()){
            return res;
        }
        backtrace(digits,0);
        return res;
    }

    private void backtrace(String digits, int i) {
        if (tmp.size() == digits.length()) {
            res.add(toStr(tmp));
            return;
        }
        for (int j = i; j < digits.length(); j++) {
            char digit = digits.charAt(j);
            String s = array[digit - '1'];
            for (int k = 0; k < s.length(); k++) {
                char c = s.charAt(k);
                tmp.add(c);
                backtrace(digits, j + 1);
                tmp.removeLast();
            }
        }
    }

    private String toStr(LinkedList<Character> tmp) {
        StringBuilder builder = new StringBuilder();
        tmp.forEach(builder::append);
        return builder.toString();
    }


}
