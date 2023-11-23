package com.alg.exercise.mid.topcode20221107;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/generate-parentheses/?favorite=2cktkvj
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis p = new GenerateParenthesis();
        List<String> res = p.generateParenthesis(2);
        p.printList(res);
    }

    private void printList(List<String>  list){
        list.forEach(System.out::println);
    }


    public List<String> generateParenthesis(int n) {
        //子集合问题,回溯算法
        //n对括号，一共2n个左右括号。
        //合法的括号组合，左括号数量 = 右括号数量 。
        //对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p)
        // 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量
        //例如："))((" 括号组合，子串中的左括号小于右括号数量，则不合法
        List<String> res = new ArrayList<>();
        StringBuilder track = new StringBuilder();

        backTrack(res, track, n, n);
        return res;


    }

    /**
     * @param res
     * @param track
     * @param left
     * @param right
     */
    public void backTrack(List<String> res, StringBuilder track, int left, int right) {
        //终止条件(应该 左括号的数量都大于或等于右括号的数量)
        if (right < left) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }
        //选择.加入一个左括号
        track.append("(");
        //回溯
        backTrack(res, track, left - 1, right);
        //撤销选择
        track.deleteCharAt(track.length() - 1);

        //选择.加入一个右括号
        track.append(")");
        //回溯
        backTrack(res, track, left, right - 1);
        //撤销选择
        track.deleteCharAt(track.length() - 1);
    }


}
