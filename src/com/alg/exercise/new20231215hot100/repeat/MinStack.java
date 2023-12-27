package com.alg.exercise.new20231215hot100.repeat;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * @Author: gu
 * @Date: 2023/12/26 下午12:20
 */
public class MinStack {

    //使用单调栈保存当前栈中的最小元素
    private Stack<Integer> stack;
    private LinkedList<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        // 10 , 1
        // 1, 10

        if(min.isEmpty()){
            min.addLast(val);
        }else {
            if(min.getLast() >= val){
                min.addLast(val);
            }
        }

    }

    public void pop() {
        Integer n = stack.pop();
        if(min.getLast().equals(n)){
            min.removeLast();
        }
    }

    public int top() {
         return stack.peek();
    }

    public int getMin() {
        return min.getLast();
    }

}
