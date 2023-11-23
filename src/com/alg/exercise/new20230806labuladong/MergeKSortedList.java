package com.alg.exercise.new20230806labuladong;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并k个有序列表
 * <p>
 * 使用最小堆
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        //先插入每个列表的头节点
        for (ListNode n : lists) {
            if(n != null){
                queue.add(n);
            }

        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if(node.next != null){
                queue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
