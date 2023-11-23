package com.alg.exercise.easy;

import java.util.Stack;

/**
 * 字符串相加
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 输入：num1 = "11", num2 = "123"
 输出："134"

 输入：num1 = "456", num2 = "77"
 输出："533"


 */
public class StringAdd {

    public static void main(String[] args) {
//        String num1 = "11", num2 = "123";
//        String num1 = "456", num2 = "77";
//        String num1 = "4560000", num2 = "77";
        String num1 = "999999999", num2 = "1111111";
        System.err.println(addStrings(num1,num2));
    }


    public static String addStrings(String num1, String num2) {
        int jinwei = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        Stack<Integer> stack = new Stack<>();
        for( ; i >=0 || j >= 0;i--,j--){

           int sum =( i < 0 ? 0:Integer.valueOf(num1.charAt(i)+"") )+ (j<0?0: Integer.valueOf(num2.charAt(j)+"")) + jinwei;
           if(sum >= 10){
               stack.push(sum - 10);
               jinwei = 1;
           }else {
               stack.push(sum);
               jinwei = 0;
           }
        }
        if(jinwei == 1 ){
            stack.push(1);
        }
        StringBuilder sum = new StringBuilder();
        while (!stack.isEmpty()){
            sum.append(stack.pop());
        }
        return sum.toString();
    }

}
