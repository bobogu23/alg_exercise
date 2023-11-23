package com.alg.exercise.easy.topcode20220829;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 * 合并区间
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals1 = {{1,4},{4,5} };
        printIntervals(merge(intervals1));

    }

    public static void printIntervals(int[][] intervals){
        Arrays.stream(intervals).forEach(arr->{
            if(arr != null){
                StringBuilder s = new StringBuilder();
                Arrays.stream(arr).forEach(a-> s.append(a).append(","));
                System.err.println(s.substring(0,s.length()-1));;
            }

        });
    }


    /**
     * 每个区间按照 start 排序，
     * 有交集的合并，取最大的end 做为合并后区间的end
     * 没交集放入结果集中
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        if(intervals .length == 1 ){
            return intervals;
        }
         int[][] res = new int[intervals.length][];
        //排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        res[0] = intervals[0];
        int resIndex = 0;
        for(int i = 1;i< intervals.length;i++){
            int[] cur = intervals[i];
            //当前Interval start 在 res最后一个interval 区间内，则判断end 是否大于 cur interval 的end，
            //如果大于，可以合并
            int[] lastInterval = res[resIndex];
            if(cur[0] <= lastInterval[1]){
                lastInterval[1] = Math.max(cur[1],lastInterval[1]);
            }
            else {
                //不在res中的最后一个区间内，插入当前区间
                res[++resIndex] = cur;
            }
        }
        return Arrays.copyOf(res,resIndex+1);
    }
}
