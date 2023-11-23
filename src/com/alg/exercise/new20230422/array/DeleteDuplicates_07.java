package com.alg.exercise.new20230422.array;

import com.alg.exercise.new20230414.link.LastKNodeOfList_08;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 使用双指针，slow,fast.
 * fast遍历列表的每个节点，与slow所指的节点比较，如果不同 ，则slow.next =fast ，然后指针移动。如果相同，则不移动。
 */
public class DeleteDuplicates_07 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next =l2;
        l2.next =l3;
        l3.next =l4;
        l4.next =l5;
        DeleteDuplicates_07 d = new DeleteDuplicates_07();

        ListNode l = d.deleteDuplicates(l1);
        l.print();

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode h = head;
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return h;
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
