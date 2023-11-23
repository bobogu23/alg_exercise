package com.alg.exercise.mid.topcode20221107;

import java.util.Arrays;
import java.util.Comparator;

public class MergeInterval_56 {

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5}};
        int[][] merged = merge(intervals);
        System.err.println(merged);

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        //先根据interval 的第一个元素给数组排序
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        //从第二个数组开始，判断start 是否在前一个数组范围之内，如果存在，则可以合并
        int[][] result = new int[intervals.length][];
        result[0] = intervals[0];
        int resultIndex = 0 ;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur =  intervals[i];
            int start = cur[0];
            int[] pre = result[resultIndex];
            if(pre[1]>=start){
                pre[1] = Math.max(cur[1],pre[1]);
            }else {
                result[++resultIndex] = intervals[i];
            }
        }

        return Arrays.copyOf(result,resultIndex+1);
    }


}
