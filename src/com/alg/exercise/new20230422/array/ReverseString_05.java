package com.alg.exercise.new20230422.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/reverse-string/
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 双指针，left,right,
 * left 从头开始遍历，right 从尾开始遍历，交换字符
 */
public class ReverseString_05 {
    public static void main(String[] args) {
        char[] array= {'H','a','n','n','a','h'};
        ReverseString_05 r =new ReverseString_05();
        r.reverseString(array);
        Arrays.asList(array).forEach(System.out::print);

    }


    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            sw(s,left,right);
            left++;
            right--;

        }
    }

    public void sw(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;

    }


}
