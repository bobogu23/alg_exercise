package com.alg.exercise.new20231009hot100.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/min-stack/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * 普通栈 支持 pop，top操作，
 * 关键是取最小元素。
 * <p>
 * 使用一个list存放最小元素，往后追加。
 * 每次push 数据n的时候，判断n是否小于 等于 list的最后一个元素，如果是 追加到list后面。
 * 如果大于 最后一个元素，说明即使把这个n pop出去了，也不影响最小值的获取，因为去掉n，最小值还是原来的最小值，而不是n。
 *
 * @author ben.gu
 */
public class MinStack_02 {
    public static void main(String[] args) {
        MinStack_02 m = new MinStack_02();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.err.println(m.getMin());
        m.pop();
        System.err.println(m.getMin());
        m.pop();
        System.err.println(m.getMin());
    }

    private Stack<Integer> stack;
    private LinkedList<Integer> minList;

    public MinStack_02() {
        stack = new Stack<>();
        minList = new LinkedList<>();
    }

    public void push(int val) {
        stack.push(val);
        //判断是否加入 minlist
        if (minList.isEmpty()) {
            minList.addLast(val);
        } else {
            if (minList.getLast() >= val) {
                minList.addLast(val);
            }
        }

    }

    public void pop() {
        Integer val = stack.pop();
        if (minList.getLast().equals(val)) {
            minList.removeLast();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.getLast();
    }

}
