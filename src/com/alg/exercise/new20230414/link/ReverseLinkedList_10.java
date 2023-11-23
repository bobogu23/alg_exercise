package com.alg.exercise.new20230414.link;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 使用递归，定义reverse函数 返回head之后的链表 反转之后的头节点
 *
 * head -> (2<-3<-4<-5<-6), 6 是last.
 * 只需将 2 的next改成head（head.next.next=head）。 head.next =null
 *
 */
public class ReverseLinkedList_10 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;

        ReverseLinkedList_10 r =new ReverseLinkedList_10();

        ListNode listNode = r.reverseList(l1);
        listNode.print();


    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null){
            return  head;
        }
        ListNode last = reverseList(head.next);
        head.next.next =head;
        head.next = null;
        return last;

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
