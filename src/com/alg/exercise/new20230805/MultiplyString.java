package com.alg.exercise.new20230805;

/**
 * https://leetcode.cn/problems/multiply-strings/
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * 用一个数组去存放 两个数字中每个位置上的数字的乘积
 */
public class MultiplyString {
    public static void main(String[] args) {
        MultiplyString m = new MultiplyString();
        System.err.println(m.multiply("123","456"));
    }

    public String multiply(String num1, String num2) {
        int i = num1.length();
        int j = num2.length();
        int[] res = new int[i + j];

        //从个位开始做乘法
        for (int m = i - 1; m >= 0; m--) {
            for (int n = j - 1; n >= 0; n--) {
                int a = num1.charAt(m) - '0';
                int b = num2.charAt(n) - '0';
                int multi = a * b;
                int p1 = m + n + 1;//计算结果multi的个位
                int p2 = m + n;//计算结果multi的十位
                int sum = res[p1] + multi;
                res[p1] = (sum) % 10; //与现有位置上的数字相加 跟10取余，
                res[p2] = (sum) / 10 + res[p2]; //与个位数字相加/10，得到十位上的数字值
            }
        }

        //去掉开头的0
        int k = 0;
        while (k < res.length && res[k] == 0) {
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for (int y = k; y < res.length; y++) {
            sb.append(res[y]);
        }
        String s = sb.toString();
        return s.length() == 0 ? "0":s;
    }

}
