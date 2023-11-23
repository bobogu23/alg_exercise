package com.alg.exercise.new20231009hot100;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-100-liked
 * 删除链表的倒数第 N 个结点
 * <p>
 * 加个哨兵节点，免去考虑边界节点的情况
 * <p>
 * 删除倒数第n个节点 x ，需要找到倒数第n+1个节点 a , a.next = x.next
 * <p>
 * 双指针，p1,p2。 p1 指针先走n步，然后p1,p2一起往后遍历链表，直到p1 达到链表结尾。
 * p2.next = p2.next.next
 *
 * @author ben.gu
 */
public class RemoveNthFromEnd_25 {

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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode p1 = sentinel;
        ListNode p2 = sentinel;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return sentinel.next;
    }

}
