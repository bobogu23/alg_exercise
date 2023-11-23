package com.alg.exercise.easy.topcode20220829;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/interval-list-intersections/
 * 区间交集
 */
public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] a = {{0,2},{5,10},{13,23},{24,25}};
        int[][] b = {{1,5},{8,12},{15,24},{25,26}};
        intervalIntersection(a,b);
    }

    /**
     * 区间a,b, 有交集的条件
     * a[1]>=b[0] && b[1]>=a[0]
     * 交集的区间特点，interval[0]= max(a[0],b[0]) ,interval[1] = min (a[1],b[1])
     * <p>
     * 区间数组下标怎么移动？
     * a[1]>b[1],移动b 所在数组的下标，否则移动a所在数组的下标
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public  static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int[][] res = new int[firstList.length+ secondList.length][];
        int i = 0, j = 0;
        int resIndex = 0 ;
        while (i < firstList.length && j < secondList.length) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            if (a[1] >= b[0] && b[1] >= a[0]) {
               int[] intersection = new int[2];
                intersection[0] = Math.max(a[0],b[0]);
                intersection[1] = Math.min(a[1],b[1]);
                res[resIndex] = intersection;
                resIndex++;
            }
            if(a[1] > b[1]){
                j++;
            }else {
                i++;
            }
        }
         return Arrays.copyOf(res,resIndex);
    }

}
