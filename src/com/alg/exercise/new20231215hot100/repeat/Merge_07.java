package com.alg.exercise.new20231215hot100.repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 *
 * @Author: gu
 * @Date: 2023/12/23 上午10:03
 */
public class Merge_07 {


    //1、给区间排序。
    //2、重叠区间判断
    //3、合并
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> l = new ArrayList<>();
        //排序
        Arrays.sort(intervals, (a1,a2)->a1[0]-a2[0]);

        int[] pre = intervals[0];
        for(int i = 1 ; i< intervals.length;i++){
            //重叠，合并
            int[] cur = intervals[i];
            if(pre[1] >= cur[0]){
                int[] tmp = new int[2];
                tmp[0] = pre[0];
                tmp[1] = Math.max(pre[1],cur[1]);    //取右边界最大的;
                pre = tmp;
            }
            //不重叠，pre加入list
            else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(pre[0]);
                tmp.add(pre[1]);
                l.add(tmp);
                //
                pre =  cur;
            }
        }
        //最后一个区间加入list
        List<Integer> tmp = new ArrayList<>();
        tmp.add(pre[0]);
        tmp.add(pre[1]);
        l.add(tmp);

        int[][] res = new int[l.size()][2];
        for(int i=0;i<res.length;i++){
            res[i] = new int[]{l.get(i).get(0),l.get(i).get(1)};
        }

        return res;

    }


}
