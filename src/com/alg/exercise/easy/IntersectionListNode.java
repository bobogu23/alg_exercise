package com.alg.exercise.easy;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 两个链表，两个指针。A,B 。
 * 如果有一个链表为null，则不存在相交点。
 * 同时遍历两个链表,如果一个链表遍历完，则继续指向另一个链表开始遍历，如果两个链表有相交的节点，则一定会相遇。
 *
 * 假设两个链表有相交点，则 一定有 n 个节点相同
 * 链表A 有a个节点，可以拆成2部分，m + n = a
 * 链表B 有b个节点，可以拆成2部分，x + n = b
 *
 * m+n+x = x+n+m
 *
 */
public class IntersectionListNode {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode headA = new ListNode(1,node2);


        ListNode nodeb1 = new ListNode(8,node3);
        ListNode headB =  new ListNode(1,nodeb1);
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        if(intersectionNode != null){
            intersectionNode.printListNode();
        }
        ListNode nodec5 = new ListNode(5);
        ListNode nodec4 = new ListNode(4,nodec5);
        ListNode nodec3 = new ListNode(3,nodec4);
        ListNode nodec2 = new ListNode(2,nodec3);
        ListNode headc = new ListNode(1,nodec2);
        intersectionNode = getIntersectionNode(headA, headc);
        if(intersectionNode != null){
            intersectionNode.printListNode();
        }




    }





    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2 ){
            n1  =  n1 == null ? headB:n1.next;
            n2  =  n2 == null ? headA:n2.next;
        }
        return n1;
    }

}
