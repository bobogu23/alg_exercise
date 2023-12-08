package com.alg.exercise.new20231009hot100.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * <p>
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * <p>
 * MedianFinder() 初始化 MedianFinder 对象。
 * <p>
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * <p>
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * 输出
 * [null, null, null, 1.5, null, 2.0]
 * <p>
 * 解释
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 * <p>
 * <p>
 * 解法：
 * 使用2个堆，一个大顶堆，一个小顶堆，大顶堆中的所有元素都小于 小顶堆中的元素。
 * 大顶堆顶部的元素最大 ,小顶堆中顶部的元素最小，大顶堆顶部元素 < 小顶堆顶部元素。
 * 2个堆中数据量大小不超过1.
 * <p>
 * 如果2个堆数据量一致，各取顶部的一个元素 相加 除以2.
 * 如果2个堆数据量不一致，取数据量大的顶部元素。
 * <p>
 * 难点在于维护 大顶堆中的数据 始终小于 小顶堆中的元素。
 *
 * @author ben.gu
 */
public class MedianFinder_03 {

    private PriorityQueue<Integer> large;//存放较大元素的小顶堆

    private PriorityQueue<Integer> small;//存放较小元素的大顶堆

    public MedianFinder_03() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public void addNum(int num) {
        //哪边数据量少，往哪边加元素
        if (small.size() < large.size()) {
            //往small堆中加数字时，可能这个数字 比 large中的数字大，要维护 small中的数字始终比large中的
            //数字小的关系。先把这个数字放到large中，让large堆做个排序，取顶部最小的数字 转移到small堆中。
            large.offer(num);
            small.offer(large.poll());//取large中最小的一个数字 转移到small中。
        }else{
            //往 large 堆中加数字，这个数字 可能比 small中的数字小，要维护 small中的数字始终比large中的
            //数字小的关系。先把这个数字放到small中，让small堆做个排序，取顶部最大的数字 转移到large堆中。
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return large.peek();
        }

    }


}
