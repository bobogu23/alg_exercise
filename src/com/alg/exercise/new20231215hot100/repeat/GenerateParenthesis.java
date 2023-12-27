package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  转换成有2n个位置，可以放字符（ 或者 ），组成的合法括号有多少？
 *
 *  合法括号 ：左括号数=右括号数。并且任意 0< i < len 的子字符串，左括号数 >= 右括号数
 *
 *  用两个变量 left，right 表示还剩余 多少 左，右 括号。
 *
 * @Author: gu
 * @Date: 2023/12/25 上午9:58
 */
public class GenerateParenthesis {



    public List<String> generateParenthesis(int n) {
        backtrace(n,n,track);
        return res;
    }

    private List<String> res = new ArrayList<>();
    private StringBuilder track = new StringBuilder();

    private void backtrace(int left,int right,StringBuilder track ){
        if(left ==0 && right ==0){
            res.add(track.toString());
            return;
        }
        //如果剩余左括号 > 剩余右括号 不合法
        if(left > right){
            return;
        }
        //剩余括号小于0，不合法
        if(left < 0 || right < 0){
            return;
        }
        //开始回溯
        //尝试加一个左括号
        track.append("(");
        backtrace(left-1,right,track);
        track.deleteCharAt(track.length()-1);


        //尝试加一个右括号
        track.append(")");
        backtrace(left,right-1,track);
        track.deleteCharAt(track.length()-1);
    }
}
