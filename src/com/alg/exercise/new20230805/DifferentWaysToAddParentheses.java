package com.alg.exercise.new20230805;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，
 * 计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * <p>
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104
 * <p>
 * <p>
 * 分治思想
 * 4-3*6+1
 * <p>
 * 1)以"-" 分隔，可以分成 （4）-(3*6+1)
 * 2)以"*" 分隔，可以分成 （4-3)*(6+1)
 * 3)以"+" 分隔，可以分成 （4-3*6)+(1)
 * <p>
 * 在1）的情况下，(3*6+1) 拆解， 可以拆成 (3)*(6+1)，（3*6）+（1）
 * 在2）的情况下，(4-3) 拆解， 可以拆成 (4)-(3), (6+1) 拆成 (6)+(1)
 * 在3）的情况下，(4-3*6) 拆解，(4)-(3*6), (4-3)*(6)
 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        DifferentWaysToAddParentheses d  = new DifferentWaysToAddParentheses();
        CollectionPrintUtils.printList(d.diffWaysToCompute(expression));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                //分，符号左右两边计算
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                //治，符号左右两边计算结果的集合 组合
                for (int l : left) {
                    for (int r : right) {
                        if (c == '-') {
                            res.add(l - r);
                        } else if (c == '+') {
                            res.add(l + r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }
            }
        }
        //res为空，说明expression不是运算符，是数字
        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        return res;

    }
}
