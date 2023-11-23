package com.alg.exercise.new20230808hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/
 * 下一个更高温度出现在几天后。下一个更大值的索引-当前值索引
 */
public class DailyTemperature {

    public static void main(String[] args) {
        int[] t ={30,40,50,60};
        DailyTemperature dt = new DailyTemperature();
        CollectionPrintUtils.printArray(dt.dailyTemperatures(t));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Integer> stack = new Stack<>();//存放更大值的索引
        int[] res = new int[len];
        for (int i = len-1; i >=0; i--) {
            int t = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= t) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

}
