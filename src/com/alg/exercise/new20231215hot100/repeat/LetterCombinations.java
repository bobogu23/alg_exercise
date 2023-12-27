package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: gu
 * @Date: 2023/12/25 上午9:33
 */
public class LetterCombinations {


    private List<String> res = new ArrayList<>();
    private String[] arr = {null, "abc", "def", "ghi", "jkf", "mno", "pqs", "tuv", "wxyz"};

    private LinkedList<Character> tmp = new LinkedList<>();

    //遍历字符串中的每个数字，找到对应的字符串，回溯字符串 组合
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrace(digits,0);
        return res;
    }

    // start 字符串中数字的起始位置
    private void backtrace(String digits, int start) {
        //终止条件
        if (digits.length() == tmp.size()) {
            res.add(toStr(tmp));
            return;
        }

        int len = digits.length();
        for (int i = start; i < len; i++) {
            char c = digits.charAt(i);
            String str = arr[c-'1'];
            int strlen = str.length();
            for(int j = 0;j<strlen;j++){
                char w = str.charAt(j);
                tmp.add(w);
                backtrace(digits,i+1);
                tmp.removeLast();
            }
        }
    }

    private String toStr(LinkedList<Character> tmp) {
        StringBuilder builder = new StringBuilder();
        for (Character c : tmp) {
            builder.append(c);
        }
        return builder.toString();
    }


}
