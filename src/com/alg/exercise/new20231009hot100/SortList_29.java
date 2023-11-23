package com.alg.exercise.new20231009hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 递归。
 * 将链表拆成左右两部分l,r，左右两部分排序后，合并 l,r
 *
 * 左右两部分也分别拆成更小的左右两部分，一直拆到 左右两部分为一个节点截止。
 *
 *
 * @author ben.gu
 */
public class SortList_29 {

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

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode p = head;
        ListNode pre = null;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (p != null) {
            pre = p;
            queue.add(p);
            p = p.next;
            pre.next = null;
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        return dummy.next;
    }
}
