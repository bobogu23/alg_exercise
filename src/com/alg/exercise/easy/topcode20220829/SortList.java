package com.alg.exercise.easy.topcode20220829;

/**
 * https://leetcode.cn/problems/sort-list/?plan=leetcode_75&plan_progress=zci8d5e
 */
public class SortList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode listNode = sortList(l1);
        listNode.print();
    }

    //归并排序，将链表拆分成一半，各自排好序后，再合并两个有序链表。
    //链表一直拆分到只有一个节点，使用快慢指针找到中间节点
    //中间节点要把next 断掉
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            if (fast == null || fast.next == null) {
                mid = slow;
            }
            slow = slow.next;
        }
        //把中间节点的next断掉，形成2个链表
        mid.next = null;
        ListNode l1 = sortList(head);
        //此时slow 是mid的下一个节点
        ListNode l2 = sortList(slow);
        //合并2个有序链表
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode h = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                h.next = cur1;
                cur1 = cur1.next;
                h = h.next;
            } else {
                h.next = cur2;
                cur2 = cur2.next;
                h = h.next;
            }
        }

        h.next = cur1 != null ? cur1 : cur2;
        return dummy.next;
    }


    public static class ListNode {
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

        public void print() {
            System.err.println(val);
            if (next != null) {
                next.print();
            }
        }
    }
}
