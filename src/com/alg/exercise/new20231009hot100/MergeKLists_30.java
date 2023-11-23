package com.alg.exercise.new20231009hot100;

import java.util.PriorityQueue;

/**
 * @author ben.gu
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 使用最小堆，将每个链表的头节点放入堆中
 */
public class MergeKLists_30 {

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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        ListNode dumy = new ListNode(-1);
        ListNode cur = dumy;

        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){//头节点取出来后，把下一个节点放入堆中排序
                queue.add(node.next);
            }
        }
        return dumy.next;
    }
}
