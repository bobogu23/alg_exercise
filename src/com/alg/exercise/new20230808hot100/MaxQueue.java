package com.alg.exercise.new20230808hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
 * 队列最大值.若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 用两个队列，
 * 一个队列按顺序存放加入队列的数据，
 * 一个队列存放当前队列中的最大值。
 * pop的时候，
 */
public class MaxQueue {
    private Deque<Integer> queue = new LinkedList<>();
    private MonotonicQueue mQueue = new MonotonicQueue();

    public MaxQueue() {
    }

    public int max_value() {
        if (queue.isEmpty()) {
            return -1;
        }
        return mQueue.max();
    }

    public void push_back(int value) {
        queue.addLast(value);
        mQueue.push(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer first = queue.pollFirst();
        //判断是否要从单调队列中移除
        mQueue.pop(first);
        return first;
    }

    private class MonotonicQueue {
        private Deque<Integer> queue = new LinkedList<>();

        public void push(int val) {
            while (!queue.isEmpty() && queue.getLast() < val) {
                queue.pollLast();
            }
            queue.addLast(val);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int val) {
            if (queue.getFirst() == val) {
                queue.pollFirst();
            }
        }
    }
}
