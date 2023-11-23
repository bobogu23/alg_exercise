package com.alg.exercise.new20230806labuladong;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/?envType=list&envId=9zwo3ww5
 * 生成括号的组合。
 * <p>
 * 括号合法，则左括号数 >= 右括号数
 * 使用回溯算法。
 * 1、终止条件
 * 2、选择
 * 3、撤销选择
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        StringBuilder builder = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(n, n, builder, res);
        return res;
    }


    /**
     * @param left    左括号数量
     * @param right   右括号数量
     * @param builder
     * @param res
     */
    private void backtrack(int left, int right, StringBuilder builder, List<String> res) {
        //左括号比右括号多，不合法
        if (left > right) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }

        //终止条件
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }

        //加一个左括号
        builder.append("(");
        backtrack(left - 1, right, builder, res);
        //撤销
        builder.deleteCharAt(builder.length() - 1);

        //加一个右括号
        builder.append(")");
        backtrack(left, right - 1, builder, res);
        builder.deleteCharAt(builder.length() - 1);
    }

}
