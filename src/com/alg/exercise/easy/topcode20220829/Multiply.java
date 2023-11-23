package com.alg.exercise.easy.topcode20220829;

import java.math.BigInteger;
import java.util.*;

/**
 * https://leetcode.cn/problems/multiply-strings/?plan=leetcode_75&plan_progress=zci8d5e
 */
public class Multiply {
    public static void main(String[] args) {
        System.err.println(multiply("9","9"));
    }

    public static String multiply(String num1, String num2) {
        //用2个栈存入2个字符串中的数字，
        //一次取出第一个栈中的一个数字，与第二个栈中的每个数字做乘法，求和。
        //第二个栈中的数字，每取出一个数字，乘积*10.
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        List<LinkedList<Integer>> multiResults = new ArrayList<>();
        int zeroSize = 0;
        for (int j = num2.length() - 1; j >= 0; j--) {
            LinkedList<Integer> queue = new LinkedList<>();
            for (int x = 0; x < zeroSize; x++) {
                queue.addLast(0);
            }

            int a = Integer.parseInt(num2.charAt(j)+"");
            int c = 0;

            for (int i = num1.length() - 1; i >= 0; i--) {

                int b = a * Integer.parseInt(num1.charAt(i)+"");
                queue.addLast((b  + c) % 10);
                c =   (b + c) / 10;
            }
            if(c>0){
                queue.addLast(c);
            }
            zeroSize++;
            multiResults.add(queue);
        }
        Stack<Integer> stack =new Stack<>();
        int d = 0;
        int count = multiResults.get(multiResults.size() - 1).size();
        for (int i = 0; i < count; i++) {
            int sum = 0;
            for (LinkedList<Integer> queue : multiResults) {
                Integer num = queue.pollFirst();
                num = num == null ? 0 : num;
                sum += num;
            }
            stack.add((sum + d) % 10);
            d = (sum + d) / 10;
        }
        if(d >0){
            stack.add(d);
        }
        String num3= "";
        while (!stack.isEmpty()){
            num3 = num3 + stack.pop();
        }

        return num3;
    }

}
