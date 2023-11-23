package com.alg.exercise.new20230414.link;

/**
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * <p>
 * 22. 链表中倒数第k个节点
 * <p>
 * 入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 两个指针，第一个指针先走k步，然后第二个指针从头开始跟第一个指针一起移动，一直到链表末尾。
 * 第二个指针所指的节点 即为倒数第k个节点
 */
public class LastKNodeOfList_08 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        LastKNodeOfList_08 l =new LastKNodeOfList_08();
        ListNode kthFromEnd = l.getKthFromEnd(l1, 6);
        kthFromEnd.print();

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode l1 = dummy;
        ListNode l2 = dummy;

        for (int i = 0; i < k; i++) {
            if (l1 != null) {
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            return null;
        }
        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2;
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
