package com.alg.exercise.new20230414.link;

/**
 * https://leetcode.cn/problems/partition-list/
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class PartitionList_06 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l31 = new ListNode(0);

        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l31;
        l31.next = l4;
        l4.next = l5;
        l5.next = l6;

//        l6.next = l1;



        PartitionList_06 p = new PartitionList_06();
        ListNode head = p.partition(l1, 3);
        head.print();

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-101, head);
        ListNode pre = dummy;//从dummy开始遍历，不用考虑边界问题
        ListNode h = dummy.next;//从dummy开始遍历，不用考虑边界问题
        //遍历链表，标记出第一个大于等于x的节点 的前一个节点 l。碰到小于x的节点，则加入到l的后面
        ListNode l = null;

        while (h != null) {
            boolean changed = false;
            ListNode cur = h;
            ListNode next = h.next;

            //第一个大于等于x的节点的前一个节点
            if (l == null && cur.val >= x) {
                l = pre;
            }

            if (cur.val < x) {
                if (l != null) {
                    pre.next = cur.next;
                    cur.next = l.next;
                    l.next = cur;
                    l = cur;
                    changed = true;
                }
            }
            //没有发生节点位置移动，才需要移动pre
            if(!changed){
                pre = h ;
            }
            h = next;
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
