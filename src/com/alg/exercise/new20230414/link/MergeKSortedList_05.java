package com.alg.exercise.new20230414.link;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 解法：
 * 使用最小堆，遍历所有链表，然后取出堆中的节点组成一个新的链表
 */
public class MergeKSortedList_05 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next =l12;
        l12.next =l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next =l22;
        l22.next =l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next =l32;

        ListNode l4 =null;
        ListNode[] listNodes ={l11,l4 };

        MergeKSortedList_05 m = new MergeKSortedList_05();
        ListNode listNode = m.mergeKLists(listNodes);
        listNode.print();

    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode l : lists) {
            ListNode n = l;
            while (n != null) {
                queue.offer(n);
                n = n.next;
            }
        }
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
        }

        return dummy.next;

    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            System.err.print(val + ",");
            if (this.next != null) {
                this.next.print();
            }
        }
    }


}
