package com.alg.exercise.easy.topcode20220829;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
 * https://leetcode.cn/problems/remove-covered-intervals/
 * <p>
 * 区间，按start大小升序排列，如果start相同 按照end降序排列
 * intervals[0][0] < intervals[1][0] && intervals[0][1] > intervals[1][1] 则
 * intervals[1] 被 intervals[0] 覆盖
 */
public class RemoveCoveredIntervals {
    public static void main(String[] args) {

        //intervals = [[1,4],[3,6],[2,8]]
        int[][] intervals = {{1,4},{3,6},{2,8}};
        System.err.println(removeCoveredIntervals(intervals));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals.length;
        }
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int coveredSize = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= left && interval[1] <= right) {
                coveredSize++;
            } else if (interval[0] <= right && interval[0] >= left && interval[1] > right) {
                right = interval[1];
            }
            //没有交集，移动left,right
            else if (interval[0] > right) {
                left = interval[0];
                right = interval[1];
            }
        }
        return intervals.length - coveredSize;

    }


}
