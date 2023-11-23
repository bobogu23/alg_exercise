package com.alg.exercise.easy.topcode20220829;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/happy-number/?plan=leetcode_75&plan_progress=zci8d5e
 */
public class HappyNum {

    public static void main(String[] args) {

    }

    /**
     * 如果不是快乐数，会进入无限循环中。
     * 3位最大的数字999，计算每一位上数字的平方和为243,因此只会在243以内循环
     * 4位最大数字，只会在324内循环
     * 13位最大数字，只会在1053内循环，
     * 因此不可能无限大
     Digits	Largest	Next
     1	9	81
     2	99	162
     3	999	243
     4	9999	324
     13	9999999999999	1053
     * @param n
     *
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;

    }

    public int getNext(int i ){
        int sum = 0;
        while (i > 0){
            int r =  i%10;
            i = i/10;
            sum += r*r;
        }
        return sum;
    }
}
