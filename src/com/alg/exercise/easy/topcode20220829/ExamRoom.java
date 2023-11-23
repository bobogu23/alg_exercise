package com.alg.exercise.easy.topcode20220829;

import javax.xml.soap.SAAJResult;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/exam-room/
 * <p>
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * <p>
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * 返回 ExamRoom(int N) 类，
 * 它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；
 * 函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。
 * 每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 */
public class ExamRoom {

    // 将端点 p 映射到以 p 为左端点的线段
    private Map<Integer, int[]> startMap;
    // 将端点 p 映射到以 p 为右端点的线段
    private Map<Integer, int[]> endMap;
    // 根据线段长度从小到大存放所有线段
    private TreeSet<int[]> pq;
    private int N;

    public ExamRoom(int n) {
        this.N = n;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
            // 算出两个线段的长度
            int distA = distance(a);
            int distB = distance(b);
            if(distA == distB){//距离相同，取索引小的
                return b[0] - a[0];
            }
            // 长度更长的更大，排后面
            return distA - distB;
        });
        // 在有序集合中先放一个虚拟线段(类似于链表中的哨兵)
        addInterval(new int[]{-1, N});

    }

    public void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    /* 去除一个线段 */
    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    /* 计算一个线段的长度 */
    private int distance(int[] intv) {
        int x = intv[0];
        int y = intv[1];
        if (x == -1) return y;
        if (y == N) return N - 1 - x;
        // 中点和端点之间的长度
        return (y - x) / 2;
    }

    public int seat() {
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;//计算座位
        if (x == -1) {//
            seat = 0;
        } else if (y == this.N) {
            seat = this.N - 1;
        } else {
            seat = (y - x) / 2 + x;
        }
        //最长线段 一分为二
        int[] left =new int[]{x,seat};
        int[] right =new int[]{seat,y};
        //删除最长线段
        removeInterval(longest);
        //增加切分之后的线段
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        //取出左右线段
        int[] left = startMap.get(p);
        int[] right = endMap.get(p);
        //合并
        int[] merged = new int[]{left[0],right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);

    }

}
