package com.alg.exercise.new20231009hot100.stack;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * 单调栈
 *
 * @author ben.gu
 */
public class DailyTemperatures_04 {
    public static void main(String[] args) {
        int[] t = {73,74,75,71,69,72,76,73};
        DailyTemperatures_04 temp = new DailyTemperatures_04();
        int[] res = temp.dailyTemperatures(t);
        CollectionPrintUtils.printArray(res);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        //倒着遍历
        for (int i = temperatures.length - 1; i >= 0; i--) {
            //stack中保存的下一个更高的温度t1 ，小于 当前温度 t2，说明 t1不可能是t2的下一个更高的问题，剔除掉
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 :( stack.peek() - i);
            stack.push(i);
        }
        return res;
    }

}

