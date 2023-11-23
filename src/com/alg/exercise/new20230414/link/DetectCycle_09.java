package com.alg.exercise.new20230414.link;

/**
 * https://leetcode.cn/problems/c32eOV/
 * 剑指 Offer II 022. 链表中环的入口节点
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。
 * 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null.
 * <p>
 * 快慢指针，假设链表头节点到环的入口节点长度为n，环的长度为m，
 * 慢指针走n+m步，则快指针走n+m*a 步能追到 慢指针，说明存在环。
 * 此时如果从头节点走x步，快指针也走x步，能碰头则是环的入口
 */
public class DetectCycle_09 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);

        l1.next = l2;
//        l2.next = l1;
//        l3.next = l4;
//        l4.next = l2;

        DetectCycle_09 d = new DetectCycle_09();
        ListNode entrance = d.detectCycle(l1);
        System.err.println(entrance.val);
        ;
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode h = head;
        boolean hasCycle = true;
        while (true) {
            slow = slow.next;
            //判断不存在环的情况
            if (fast == null || fast.next == null) {
                hasCycle = false;
                break;
            }
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if(!hasCycle){
            return null;
        }
        while (h != fast) {
            h = h.next;
            fast = fast.next;
        }
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
