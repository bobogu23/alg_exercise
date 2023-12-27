package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * @Author: gu
 * @Date: 2023/12/25 下午8:51
 */
public class Partition {



    public List<List<String>> partition(String s) {
        backtrace(s,0);
        return res;
    }
    private List<List<String>> res = new ArrayList<>();
    private LinkedList<String> tmp = new LinkedList<>();

    private void backtrace(String s, int start){
        //走到字符串末尾
        if(start == s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }

        int len = s.length();

        for(int i = start ;i <len;i++){
             if(!ishw(s,start,i)){
//                 s[start ...i ] 不是回文串
                 continue;
             }
             tmp.add(s.substring(start,i+1));
             backtrace(s,i+1);
             tmp.removeLast();
        }

    }

    private boolean ishw(String s,int start,int end){
        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
