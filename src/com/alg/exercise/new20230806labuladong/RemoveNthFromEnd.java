package com.alg.exercise.new20230806labuladong;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=list&envId=9zwo3ww5
 * 删除倒数第n个节点
 * <p>
 * 增加哨兵节点，（不用考虑边界节点）
 * 递归，找到倒数第n+1个节点n , n.next = n.next.next
 */
public class RemoveNthFromEnd {



    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        //要删除倒数第n个节点，要找到倒数第n+1个节点
        ListNode p = findFromEnd(sentinel, n + 1);
        p.next = p.next.next;
        return sentinel.next;
    }

    //双指针，链表长度m,定义指针p，先走n步，距离链表末尾还有m-n步。此时在链表开头在放一个指针l
    // 两个指针同时往前走。当指针p走到末尾时，走了m-n步，l也走m-n步，此时l，恰好在倒数第n个节点上
    public ListNode findFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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
