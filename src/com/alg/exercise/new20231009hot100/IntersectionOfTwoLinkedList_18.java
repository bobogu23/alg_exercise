package com.alg.exercise.new20231009hot100;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 两个指针，分别遍历headA,headB,
 * 遍历完后，再遍历另一个链表，如果出现相同的节点，说明相交
 *
 * @author ben.gu
 */
public class IntersectionOfTwoLinkedList_18 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode p1 = headA;
         ListNode p2 = headB;
         while (p1 != p2){
             if(p1 == null){
                 p1 = headB;
             }else {
                 p1 = p1.next;
             }

             if(p2 == null){
                 p2 = headA;
             }else {
                 p2 = p2.next;
             }
         }
        return p1;
    }

}
