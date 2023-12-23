package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 * @Author: gu
 * @Date: 2023/12/23 下午4:42
 */
public class GetIntersectionNode {


    //遍历各自链表，然后遍历对方链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2){ // null == null
            if(p1 == null){
                p1= headB;
            }else{
                p1=p1.next;
            }
            if(p2 == null){
                p2= headA;
            }else{
                p2=p2.next;
            }
        }
        return p1;
    }
}
