package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/multiply-strings/
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 1.从个位开始 两数相乘，将结果放到对应位置的数组上
 * 2.返回结果时，如果开头有0，截掉
 */
public class StringMultiply {


    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int m1 = num1.charAt(i) - '0';
                int m2 = num2.charAt(j) - '0';

                int p1 = i + j;//相乘后结果的第一位存放在数组的位置
                int p2 = i + j + 1;//相乘后结果的第二位存放在数组的位置
                int mul = m1 * m2 + result[p2];//
                result[p1] += mul / 10;
                result[p2] = mul % 10 ;
            }
        }

        //找到第一个不为0的位置
        int i = 0;
        for (; i < result.length; i++) {
                if(result[i] != 0){
                    break;
                }
        }
        String s ="";
        for(; i < result.length; i++){
            s= s + result[i];
        }
        return s .equals("")  ? "0":s;
    }

}
