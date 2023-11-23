package com.alg.exercise.new20230414.link;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第 N 个结点
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 假设链表长度为m,倒数第n个节点，需要从头开始走m-n 步，走到a节点，然后将a.next=a.next.next
 * <p>
 * 双指针，第一个指针p1,先走n步，然后第二个指针p2，和p1一起移动，直到p1到达链表末尾。
 */
public class RemoveNthNode_03 {

    public static void main(String[] args) {
        RemoveNthNode_03 r  =new RemoveNthNode_03();
        ListNode l1 =new ListNode(1);
        ListNode l2 =new ListNode(2);
        ListNode l3 =new ListNode(3);
        ListNode l4 =new ListNode(4);
        ListNode l5 =new ListNode(5);

        l4.next =l5;
        l3.next =l4;
//        l2.next =l3;
//        l1.next =l2;

        ListNode head = r.removeNthFromEnd(l1, 1);
        head.print();


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = head;
        ListNode p2 = dummy;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        while (p1 != null ) {
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2.next != null ) {
            p2.next = p2.next.next;
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

        public void print(){
            System.err.print(val+",");
            if(this.next != null){
                this.next.print();
            }
        }
    }
}
