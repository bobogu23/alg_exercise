package com.alg.exercise.new20230806;

/**
 * https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/
 * <p>
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * <p>
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * <p>
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * <p>
 * 请你返回让 s 平衡的最少插入次数。
 */
public class MinimumInsertionsToBalanceAParenthesesString {

    public static void main(String[] args) {
        String s = "((((((";
        MinimumInsertionsToBalanceAParenthesesString m = new MinimumInsertionsToBalanceAParenthesesString();
        System.err.println(m.minInsertions(s));
    }


    public int minInsertions(String s) {
        int res = 0;
        int need = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                need += 2;
                //一个左括号对应两个右括号，所以右括号必须是偶数
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            } else if (c == ')') {
                need--;
                //右括号多了
                if (need == -1) {
                    res += 1;//左括号插入一个
                    need = 1; //一个左括号 对应2个右括号
                }
            }
        }
        return res + need;
    }


}
