package com.alg.exercise.new20231215hot100.repeat;

import com.alg.exercise.utils.ListNode;

/**
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * @Author: gu
 * @Date: 2023/12/23 下午5:30
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        IsPalindrome p  = new IsPalindrome();
        boolean res = p.isPalindrome(l1);
        System.err.println(res);


    }


    //翻转成新的链表，然后比较两个链表是否相同
    public boolean isPalindrome(ListNode head) {
        ListNode list = copy(head);
        ListNode l = reverse(list);
        ListNode p1 = l;
        ListNode p2 = head;
        while (p1 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 =p1.next;
            p2 =p2.next;
        }
        return true;
    }

    private  ListNode copy(ListNode head){
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        ListNode p = head;
        while (p != null){
            d.next = new ListNode(p.val);
            p = p.next;
            d = d.next;
        }
        return dummy.next;

    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode h = reverse(head.next);
        head.next.next=head;
        head.next = null;
        return h;
    }

}
