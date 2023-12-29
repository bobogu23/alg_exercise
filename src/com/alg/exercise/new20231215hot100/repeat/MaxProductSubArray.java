package com.alg.exercise.new20231215hot100.repeat;

import com.sun.xml.internal.rngom.digested.DPattern;

/**
 * @Author: gu
 * @Date: 2023/12/27 下午7:08
 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        MaxProductSubArray m = new MaxProductSubArray();
        int[] a ={-2,0,-1};
         int res = m.maxProduct(a);
        System.err.println(res);

    }

    //乘积 有可能是 负数*负数，所以要保留 连续子数组的负数乘积的最小值
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] min = new int[len];
        int[] max = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = nums[i];
            max[i] = nums[i];
        }


        for (int i = 1; i < len; i++) {
            int n = nums[i];
            min[i] = min(n,min[i-1] * n ,max[i-1] *n );
            max[i] = max(n,min[i-1] * n ,max[i-1] *n );
        }

        int res  = -11;
        for(int i = 0;i<len;i++){
            res = Math.max(max[i],res);
        }
        return res;
    }

    private int min (int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    private int max (int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }

}
