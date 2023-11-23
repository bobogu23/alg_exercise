package com.alg.exercise.easy.topcode20220829;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 删除倒数第n个节点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?plan=leetcode_75&plan_progress=zci8d5e
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
//        head.next = n2;
//        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = removeNthFromEnd(head, 1);
        listNode.print();
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode sentinel = new ListNode(0, head);
        //第一个指针1 先走n步，如果走到链表结尾则还剩 len-n 步，此时第二个指针2从head节点开始走，
        //指针1和指针2一起走len-n 步，则指针2所在的节点就是倒数第n个节点
        ListNode l1 = head;
        for (int i = 0; i < n ; i++) {
            l1 = l1.next;
        }
        ListNode l2 = sentinel;
        while (l1 != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2.next != null){
            l2.next = l2.next.next;
        }
        return sentinel.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //递归到最后一个节点，开始计数，找到要删除的节点，将要删除的节点的前一个节点指向删除节点的下一个节点
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode removed = null;
        for (int i = 0; i < n; i++) {
            removed = stack.pop();
        }
        ListNode pre = stack.isEmpty() ? null: stack.peek();
        if (pre != null) {
            pre.next = removed.next;
        }else if(removed.next != null){
            head = removed.next;
        }else {
            head = null;
        }
        return  head;
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
