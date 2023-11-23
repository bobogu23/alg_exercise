package com.alg.exercise.easy.topcode20220829;

import java.util.ArrayList;
import java.util.List;

/**
 * 表达式设计优先级
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */
public class DiffWaysToCompute {

    public static void main(String[] args) {
         String expression = "2*3-4*5";
        System.err.println(diffWaysToCompute(expression));
    }

    /**
     * 分治思想。以运算符为分隔符，切分表达式，分别计算 分隔符两边的计算结果，然后通过运算符合并两边的计算结果
     *
     * @param expression
     * @return
     */
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ele = expression.charAt(i);
            if(ele == '+' || ele == '-' || ele == '*'){
                //分
                List<Integer> leftResult = diffWaysToCompute(expression.substring(0,i));
                List<Integer> rightResult = diffWaysToCompute(expression.substring(i+1));

                //治
                for(int l: leftResult){
                    for(int r: rightResult){
                          if(ele == '+' ){
                              res.add(l+r);
                          }else
                          if(ele == '-' ){
                              res.add(l-r);
                          }else if(ele == '*' ){
                              res.add(l*r);
                          }
                    }
                }
            }

        }
        //分的终止条件。为空说明 表达式 是个数字，直接返回这个数字
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
