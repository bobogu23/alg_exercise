package com.alg.exercise.new20230414.link;

/**
 * 判断链表是否有环
 * <p>
 * 使用快慢指针，慢指针走一步，快指针走两步。如果快指针能碰到慢指针说明有环
 */
public class LinkedListCycle_01 {



    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
