package com.alg.exercise.new20230414.link;

/**
 * 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>https://leetcode.cn/problems/intersection-of-two-linked-lists/</p>
 * <p>
 * 两个指针p1,p2分别遍历两个链表headA,headB.
 * p1遍历完headA之后遍历headB,
 * p2遍历完headB之后遍历headA
 * 遍历过程中判断节点是否相同，如果是，则是相交的节点
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 */
public class IntersectionNode_02 {

    public static void main(String[] args) {
        IntersectionNode_02 n = new IntersectionNode_02();
        ListNode headA = new ListNode(2);
        ListNode headA2 = new ListNode(4);
        ListNode headA3 = new ListNode(6);
        ListNode headA4 = new ListNode(7);
        headA.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;

        ListNode headB = new ListNode(1);
        ListNode headB2 = new ListNode(5);

        headB.next =headB2;
        headB2.next =headA3;

        ListNode result = n.getIntersectionNode(headA, headB);
        System.err.println("result != null ? "+(result != null));
        if(result != null){
            System.err.println("result: "+result.val);
        }



    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
             if(p1 == null){
                 p1 = headB;
             }else {
                 p1 = p1.next;
             }
            if(p2 == null){
                p2 = headA;
            }  else {
                p2 =p2.next;
            }
        }
        return  p1;
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
