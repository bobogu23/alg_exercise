package com.alg.exercise.new20231009hot100.backtrace;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 回溯算法，必须先放左括号，n个左括号的组合
 * <p>
 * 题目可以改写成有2个位置，每个位置可以放 字符（，或者字符 ），有多少种组合。
 * 这些组合有些条件
 * 1) 左右括号总数一致
 * 2）在0 ~ 2n 之间的位置上，左括号数量>= 右括号 数量
 * <p>
 * 定义变量left表示 还可以使用的左括号数，right 表示 还可以使用的右括号数
 *
 * @author ben.gu
 */
public class GenerateParenthesis_05 {

    public static void main(String[] args) {

        int n = 1;
        GenerateParenthesis_05 g = new GenerateParenthesis_05();
        List<String> strings = g.generateParenthesis(n);
        CollectionPrintUtils.printList(strings);
    }


    private List<String> res = new ArrayList<>();
    private LinkedList<Character> tmp = new LinkedList<>();


    public List<String> generateParenthesis(int n) {
        backtrace(n, n);
        return res;
    }

    private void backtrace(int left, int right) {
        //左括号剩下的多，左括号比右括号少，不合法.
        if (left > right) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        //左右括号都填满了
        if (left == 0 && right == 0) {
            res.add(toStr(tmp));
            return;
        }
        //加个左括号
        tmp.add('(');
        backtrace(left - 1, right);
        tmp.removeLast();

        //加个右括号
        tmp.add(')');
        backtrace(left, right - 1);
        tmp.removeLast();
    }

    private String toStr(LinkedList<Character> tmp) {
        StringBuilder builder = new StringBuilder();
        tmp.forEach(builder::append);
        return builder.toString();
    }


}
