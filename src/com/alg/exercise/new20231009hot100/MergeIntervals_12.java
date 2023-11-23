package com.alg.exercise.new20231009hot100;

import com.alg.exercise.utils.CollectionPrintUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 先将数组intervals排序，
 * 遍历intervals 中的每个数组，从第二个数组开始，判断数组的第一个数字 是否在上一个数组的区间内，
 * 如果在区间内，则合并。
 *
 * @author ben.gu
 */
public class MergeIntervals_12 {
    public static void main(String[] args) {
        MergeIntervals_12 m = new MergeIntervals_12();
        int[][] nums = {{1,4}, {4,5}};
        CollectionPrintUtils.printNestedIntArray(m.merge(nums));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] res = new int[intervals.length][];
        res[0] = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] arr = intervals[i];
            int left = arr[0];
            int[] pre = res[index];
            //需要合并，合并后重新放入res
            if (left >= pre[0] && left <= pre[pre.length - 1]) {
                res[index] = mergeArray(pre, arr);
            } else {
                //不存在重叠，放入res中当前数组的后面
                index++;
                res[index] = arr;
            }
        }
        int[][] res1 = new int[index + 1][];
        for (int i = 0; i <= index; i++) {
            res1[i] = res[i];
        }
        return res1;
    }

    private int[] mergeArray(int[] pre, int[] arr) {
        pre[pre.length - 1] = Math.max(arr[arr.length - 1], pre[pre.length - 1] );
        return pre;
    }

}
