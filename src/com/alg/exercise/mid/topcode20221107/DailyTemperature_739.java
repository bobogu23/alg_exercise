package com.alg.exercise.mid.topcode20221107;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/?favorite=2cktkvj
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * 求每个位置的元素之后的第一个比该元素大的元素的位置与当前元素的距离
 */
public class DailyTemperature_739 {
    public static void main(String[] args) {
        int[] t = {30,60,90};
        DailyTemperature_739 d = new DailyTemperature_739();
        int[] res = d.dailyTemperatures(t);
        Arrays.stream(res).forEach(System.out::println);

    }


    //单调栈，后进先出。
    public int[] dailyTemperatures(int[] temperatures) {
        //倒着遍历数组，放入栈中。pop先出来的是离当前元素较近的元素
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> position = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!position.isEmpty() && temperatures[position.peek()] <= temperatures[i]) {
                position.pop();
            }
            //计算后面较大元素与当前元素的距离
            result[i] = position.isEmpty() ? 0 : position.peek() - i;
            //存放当前元素的位置
            position.push(i);
        }
        return result;
    }


}
