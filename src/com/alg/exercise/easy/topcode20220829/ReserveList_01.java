package com.alg.exercise.easy.topcode20220829;

import java.util.List;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 1->2->3->4->5
 * 5->4->3->2->1
 *
 *
 * 递归遍历到队尾，用一个哨兵指向队尾节点， 从尾部开始将next指针指向前一个节点，最后返回哨兵节点的next 节点
 *
 */
public class ReserveList_01 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = reverseList(n1);
        listNode.print();

        System.err.println("------------------");
        ListNode emp = new ListNode();
        listNode = reverseList(emp);
        listNode.print();
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null ){
            return head;
        }
        ListNode sentinel = new ListNode();
        reserve(head,sentinel);
        return sentinel.next;
    }
    public static ListNode reserve(ListNode head,ListNode sentinel){
        if(head.next == null){
            sentinel.next = head;
            return head;
        }
        ListNode next = reserve(head.next,sentinel);
        next.next = head;
        head.next =null;
        return head;
    }


    // 该函数表示对head节点开头的链表进行反转，并且返回反转后的链表的头节点。
    public static ListNode reverse1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        //对head的下一个节点开头的链表进行反转，返回链表的头节点。
        //head 节点的下一个节点n 的next 节点应该指向head节点，
        //head节点的next节点指向null


        // head->1->2->3->4->5->6
        // head 节点之后的链表反转后
        //head->1<-2<-3<-4<-5<-6, last 指向6
        // head.next = 1, 1 的Next 应该指向head. head 的next 指向null
        // <-head<-1<-2<-3<-4<-5<-6


        ListNode last = reverse1(head.next);
        head.next.next =head;
        head.next = null;
        return last;
    }



    public  static class ListNode {
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

        public void print(){
            System.err.println(val);
            if(next != null){
                next.print();
            }
        }
    }
}
