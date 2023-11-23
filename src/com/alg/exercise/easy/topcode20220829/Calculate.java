package com.alg.exercise.easy.topcode20220829;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/basic-calculator/
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * 1.统计数字，sum = sum*10+num
 * 2.使用栈存放要参与运算的数字，遇到+，- 符号，将前面的数字放入栈。遇到 *，/，取出栈顶数字，参与运算，然后将结果放入栈中
 * 3.遇到括号，遇到开始的括号(, 递归调用计算方法，计算出括号中的结果，遇到结束括号),递归结束
 */
public class Calculate {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.err.println(calculate(s));
    }

    public static int calculate(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character el = s.charAt(i);
            if (!el.equals(' ')) {
                queue.addLast(el);
            }
        }
        return cal(queue);
    }

    public static int cal(Deque<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';//默认第一个数字前面是+
        int num = 0;
        while (!queue.isEmpty()) {
            Character top = queue.pop();
            if (Character.isDigit(top)) {
                num = num * 10 + (top - '0');
            }
            if(top.equals('(')){
                num = cal(queue);
            }
            //栈顶元素不是数字，或者已经到栈底了
            if (!Character.isDigit(top) || queue.isEmpty()) {
                switch (sign) {
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(num * stack.pop());
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;

                }
                sign = top;
                num = 0;
            }
            if(top.equals(')')){
                return sum(stack);
            }
        }
        //累加 stack中的数字
        return sum(stack);
    }

    private static int sum(Stack<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()){
            res+= stack.pop();
        }
        return res;
    }

}
