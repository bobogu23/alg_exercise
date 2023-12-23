package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.ListNode;

/**
 * @Author: gu
 * @Date: 2023/12/23 下午4:59
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;

        ReverseList r = new ReverseList();
        ListNode res = r.reverseList(l1);
        res.print();
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //假设head.next 已经翻转好了

        ListNode h = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return h;
    }



}
